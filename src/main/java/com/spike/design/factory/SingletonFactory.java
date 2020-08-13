package com.spike.design.factory;

import com.spike.design.singleton.Singleton;

import java.lang.reflect.Constructor;

/**
 * @description: 替代单例模式
 * @author: Spike
 * @date: 2020-05-13 16:00
 **/

/**
 * 以上通过工厂方法模式创建了一个单例对象，该框架可以继续扩展，
 * 在一个项目中可以产生一个单例构造器，所有需要产生单例的类都遵循一定的规则（构造方法是private），然后通过扩展该框架，只要输入一个类型就可以获得唯一的一个实例。
 */
public class SingletonFactory {



    private static Singleton singleton;
    static{
        try{
            Class c = Class.forName(Singleton.class.getName());
            //获取无参构造
            Constructor constructor = c.getDeclaredConstructor();
            //设置无参构造访问权限
            constructor.setAccessible(true);
            //产生一个实例
            singleton = (Singleton) constructor.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Singleton getSingleton(){
        return singleton;
    }




}
