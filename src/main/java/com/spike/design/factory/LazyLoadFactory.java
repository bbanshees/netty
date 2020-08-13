package com.spike.design.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 延迟初始化
 * @author: Spike
 * @date: 2020-05-13 16:48
 **/

public class LazyLoadFactory {

    //用于保存第一次调用时创建的对象
    private static final Map<String, Object> objectMap = new HashMap<String, Object>();

    public synchronized static AbstractProduct createProduct(String type) {
        AbstractProduct abstractProduct;
        try {
            //检查map中是否已经有这个对象
            if (objectMap.containsKey(type)) {
                abstractProduct = (AbstractProduct) objectMap.get(type);
            } else {
                if("product1".equals(type)){
                    abstractProduct = new ConcreteProduct1();
                }else{
                    abstractProduct = new ConcreteProduct2();
                }
                objectMap.put(type, abstractProduct);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return abstractProduct;
    }
}
