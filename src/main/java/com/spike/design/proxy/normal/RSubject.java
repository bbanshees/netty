package com.spike.design.proxy.normal;

/**
 * @description: 真实工作者
 * @author: Spike
 * @date: 2020-05-19 14:24
 **/

public class RSubject implements ISubject {

    private String params;

    public RSubject(ISubject iSubject,String param) throws Exception{
        if(iSubject == null){
            throw new Exception("错误");
        }else {
            this.params = param;
        }
    }

    @Override
    public void doBiz() {
        System.out.println("hello:"+params);
    }

    @Override
    public void doBizA(String info) {

        System.out.println("info："+ info);

    }
}
