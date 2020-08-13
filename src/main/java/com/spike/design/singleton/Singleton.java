package com.spike.design.singleton;

/**
 * @description:
 * 饿汉式单例在自己被加载时就将自己实例化，如果从资源利用效率角度来讲，比懒汉式单例类稍差些。但是从速度和反应时间角度来讲，则比懒汉式要稍好些。
 * @author: Spike
 * @date: 2020-05-11 15:52
 **/

public class Singleton {

    //创建静态实例
    /**
     * 1.static块比构造函数先加载
     *
     * 2.子类继承父类时，new子类的时候会先加载父类的static再加载子类的static，然后再加载父类的构造函数最后加载子类的构造函数
     */
    private static Singleton singleton = new Singleton();

    /**
     * 当类没有声明构造方法的时候,就会使用默认的构造方法, 这个默认的构造方法就是“无参构造方法”,该默认方法是public 当类声明了有参构造方法的时候,默认构造方法就失去了本身的作用。
     */
    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }

    public void doBiz(){
        System.out.println("hello s");
    }


}
