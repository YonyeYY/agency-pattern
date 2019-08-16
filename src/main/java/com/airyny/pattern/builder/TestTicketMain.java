package com.airyny.pattern.builder;

/**
 * @Author:Yonye
 * @description:
 * @Date :2019/8/16
 * @Time:11:41
 **/
public class TestTicketMain {


    public static void main(String[] args){
        TicketHelper helper=new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildChildrenForSeat("有座儿童票");
        helper.buildChildrenNoSeat("无座儿童票");
        helper.buildElderly("老人票");
        Object ticket=TicketBuilder.builder(helper);
    }
}
