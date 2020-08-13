package com.spike.design.prototype;

/**
 * @description: 原型模式通用代码
 * @author: Spike
 * @date: 2020-06-01 14:02
 **/

/**
 * 有点：性能优良
 * 原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其优点。
 *
 * 缺点：逃避构造函数的约束
 * 这既是它的优点也是缺点，直接在内存中拷贝，构造函数是不会执行的。优点就是减少了约束，缺点也是减少了约束，需要大家在实际应用时考虑
 */

/**
 * ●资源优化场景
 * 类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。
 *
 * ●性能和安全要求的场景
 * 通过new产生一个对象需要非常繁琐的数据准备或访问权限，则可以使用原型模式。
 *
 * ●一个对象多个修改者的场景
 * 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。
 *
 * 在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过clone的方法创建一个对象，然后由工厂方法提供给调用者。
 * 原型模式已经与Java融为一体，大家可以随手拿来使用
 */
public class PrototypeClass implements Cloneable {


    // 对象拷贝时构造函数确实没有被执行，
    // 这点从原理来讲也是可以讲得通的，
    // Object类的clone方法的原理是从内存中（具体地说就是堆内存）以二进制流的方式进行拷贝，重新分配一个内存块，
    // 那构造函数没有被执行也是非常正常的了
    public PrototypeClass(){
        System.out.println("构造函数被执行了");
    }




    /**
     * 原型模式的核心是一个clone方法，通过该方法进行对象的拷贝
     */
    @Override
    public PrototypeClass clone(){
        PrototypeClass prototypeClass = null;
        try{
            prototypeClass = (PrototypeClass)super.clone();
        }catch (CloneNotSupportedException e){
            //异常处理
        }
        return prototypeClass;
    }

}
