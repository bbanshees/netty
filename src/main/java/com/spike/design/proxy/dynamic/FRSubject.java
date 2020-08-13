package com.spike.design.proxy.dynamic;

/**
 * @description: 真实工作者
 * @author: Spike
 * @date: 2020-05-19 14:24
 **/

public class FRSubject implements IFSubject {

    private String params ;
    public FRSubject(String params){
        this.params = params;
    }


    @Override
    public void doBiz() {
            System.out.println("hello:" + params);



    }

    @Override
    public void doBizA(String info) {
            System.out.println("info：" + info);
    }



}
