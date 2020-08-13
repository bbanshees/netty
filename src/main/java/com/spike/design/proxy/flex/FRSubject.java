package com.spike.design.proxy.flex;

/**
 * @description: 真实工作者
 * @author: Spike
 * @date: 2020-05-19 14:24
 **/

public class FRSubject implements IFSubject {

    private String params;
    private IFSubject proxy = null;

    public FRSubject(String params) {
        this.params = params;
    }
    //找到自己的代理
    @Override
    public IFSubject getProxy() {
        this.proxy = new FProxy(this);
        return this.proxy;
    }

    @Override
    public void doBiz() {
        if(this.isProxy()){
            System.out.println("hello:" + params);
        }else {
            System.out.println("请使用指定的代理访问");
        }


    }

    @Override
    public void doBizA(String info) {
        if(this.isProxy()){
            System.out.println("info：" + info);
        }else {
            System.out.println("请使用指定的代理访问");
        }
    }

    //校验代理是否被访问
    private boolean isProxy(){
        return this.proxy != null;
    }


}
