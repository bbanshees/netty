package com.spike.design.prototype;

import java.util.ArrayList;

/**
 * @description: 浅拷贝
 * @author: Spike
 * @date: 2020-06-01 15:53
 **/
//使用原型模式时，引用的成员变量必须满足两个条件才不会被拷贝：
// 一是类的成员变量，而不是方法内变量；
// 二是必须是一个可变的引用对象，而不是一个原始类型或不可变对象。
public class ThingWeakCopy implements Cloneable {
    // 定义一个私有变量
    // final private ArrayList<String> arrayList = new ArrayList<>();
    // 要使用clone方法，类的成员变量上不要增加final关键字。浅拷贝没事
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public ThingWeakCopy clone() {
        ThingWeakCopy things = null;
        try {
            things = (ThingWeakCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return things;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(String value) {
        this.arrayList.add(value);
    }
}
