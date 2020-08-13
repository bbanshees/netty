package com.spike.design.factory;

import com.spike.design.singleton.AbstractSingletonFactory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 输入一个类型就可以获取一个该类型的单例对象，揉合了延迟加载
 * @author: Spike
 * @date: 2020-05-13 16:21
 **/

public class SingletonFactoryWithParams {

    //用于保存第一次调用时创建的对象
    private static final Map<String, Object> objectMap = new HashMap<String, Object>();

    public synchronized static <T extends AbstractSingletonFactory> T createSingleton(Class<T> c) {
        AbstractSingletonFactory abstractSingletonFactory ;
        String className ;
        className = c.getName();
        try {
            //检查map中是否已经有这个对象
            if (!objectMap.containsKey(className)) {
                Class class1 = Class.forName(className);
                // 获得无参构造
                Constructor constructor = class1.getDeclaredConstructor();
                // 设置无参构造是可访问的
                constructor.setAccessible(true);
                // 产生一个实例对象。
                abstractSingletonFactory = (AbstractSingletonFactory) constructor.newInstance();
                objectMap.put(className, abstractSingletonFactory);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return (T) objectMap.get(className);
    }
}
