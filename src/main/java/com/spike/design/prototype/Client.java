package com.spike.design.prototype;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-06-01 15:42
 **/

/**
 * 原型模式的核心是一个clone方法，通过该方法进行对象的拷贝
 */
public class Client {
    public static void main(String[] args) {
        //构造函数被执行
        PrototypeClass prototypeClass = new PrototypeClass();
        //构造函数不被执行
        PrototypeClass prototypeClass1 = prototypeClass.clone();


        // 浅拷贝
        // 是因为Java做了一个偷懒的拷贝动作，
        // Object类提供的方法clone只是拷贝本对象，其对象内部的数组、引用对象等都不拷贝，还是指向原生对象的内部元素地址，
        // 这种拷贝就叫做浅拷贝。
        // 确实是非常浅，两个对象共享了一个私有变量，你改我改大家都能改，是一种非常不安全的方式，
        // 在实际项目中使用还是比较少的（当然，这也是一种“危机”环境的一种救命方式）。
        // 你可能会比较奇怪，为什么在Mail那个类中就可以使用String类型，而不会产生由浅拷贝带来的问题呢？
        // 内部的数组和引用对象不拷贝，其他的原始类型比如int、long、char等都会被拷贝，
        // 但是对于String类型，Java就希望你把它认为是基本类型，
        // 它是没有clone方法的，处理机制也比较特殊，
        // 通过字符串池（stringpool）在需要的时候才在内存中创建新的字符串，
        // 读者在使用的时候就把String当做基本类使用即可
        ThingWeakCopy things = new ThingWeakCopy();
        things.setArrayList("spike");
        ThingWeakCopy cloneThings = things.clone();
        cloneThings.setArrayList("zed");
        System.out.println(things.getArrayList());

        //深拷贝
        ThingStrongCopy thing = new ThingStrongCopy();
        thing.setArrayList("spike");
        ThingStrongCopy cloneThing = thing.clone();
        cloneThing.setArrayList("zed");
        System.out.println(thing.getArrayList());

        /**
         *  注意！
         *  要使用clone方法，类的成员变量上不要增加final关键字。（浅拷贝没关系）
         */

    }
}
