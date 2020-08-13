package com.spike.jdkRead;

/**
 * @description:
 * @author: Spike
 * @date: 2019-08-27 16:49
 **/

public class ReadParent {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void test2() throws CloneNotSupportedException {
        ReadParent readParent = new ReadParent();
        readParent.clone();
        System.out.println("heeeeeee");
    }



    @Override
    public String toString() {
        return "ReadParent{" +
                "name='" + name + '\'' +
                '}';
    }
}
