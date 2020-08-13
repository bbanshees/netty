package com.spike.design.prototype;

import java.util.ArrayList;

/**
 * @description: 深拷贝
 * @author: Spike
 * @date: 2020-06-01 15:45
 **/

public class ThingStrongCopy implements Cloneable{

    //定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<>();
    @Override
    public ThingStrongCopy clone(){
        ThingStrongCopy things = null;
        try{
            things = (ThingStrongCopy) super.clone();
            //对类的成员变量也进行拷贝
            things.arrayList = (ArrayList<String>) this.arrayList.clone();
        }catch (CloneNotSupportedException e){
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
