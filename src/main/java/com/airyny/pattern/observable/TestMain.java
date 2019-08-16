package com.airyny.pattern.observable;


/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/16
 * @Time:10:11
 **/
public class TestMain {

    public static void main(String[] args){
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addObserver(jingDongObserver);
        observable.addObserver(taoBaoObserver);
        observable.addProudct("新产品1");
    }
}
