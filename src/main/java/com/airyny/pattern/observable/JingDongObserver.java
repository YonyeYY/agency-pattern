package com.airyny.pattern.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/16
 * @Time:10:06
 **/
public class JingDongObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.err.println("发送新产品【"+newProduct+"【同步到京东商城");
    }
}
