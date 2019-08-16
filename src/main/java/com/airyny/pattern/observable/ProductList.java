package com.airyny.pattern.observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/16
 * @Time:9:55
 **/
public class ProductList extends Observable {

    //产品列表
    private List<String> productList = null;

    //类唯一实例
    private static ProductList instance;

    //构建方法私有化
    private ProductList(){}

    /*
     * @Description 取得唯一实例
     * @return com.airyny.pattern.observable.ProductList 产品列表唯一实例
     **/
    public static ProductList getInstance(){
        if (instance == null){
            synchronized (ProductList.class){
                if (instance == null){
                    instance = new ProductList();
                    instance.productList = new ArrayList<String>();
                }
            }
        }
        return instance;
    }

    /*
     * @Description 增加观察者（电商接口）
     * @param observable 观察者
     * @return void
     **/
    public void addProductListObserver(Observer observer){
        this.addObserver(observer);
    }

    public void addProudct(String newProduct){
        productList.add(newProduct);
        System.out.println("产品列表新增了产品："+newProduct);
        //设置被观察者
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(newProduct);
    }

}
