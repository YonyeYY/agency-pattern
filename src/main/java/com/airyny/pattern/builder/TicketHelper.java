package com.airyny.pattern.builder;

/**
 * @Author:Yonye
 * @escription:
 * @Date :2019/8/16
 * @Time:11:36
 **/
public class TicketHelper {

    public void buildAdult(String info){
        System.err.println("构建成年人票逻辑："+info);
    }

    public void buildChildrenForSeat(String info){
        System.err.println("购进啊有座儿童票逻辑："+info);
    }

    public void buildChildrenNoSeat(String info){
        System.err.println("构建无座儿童票逻辑："+info);
    }

    public void buildElderly(String info){
        System.err.println("构建有老年人票逻辑："+info);
    }

    public void buildSoldier(String info){
        System.err.println("构建军人及其家属票逻辑："+info);
    }
}
