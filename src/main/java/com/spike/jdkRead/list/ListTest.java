package com.spike.jdkRead.list;

import java.util.*;

/**
 * @description: list测试类
 * @author: Spike
 * @date: 2020-06-10 13:38
 **/

public class ListTest {


    public static void main(String[] args) {

        List<String> a = new AbstractList<String>() {
            @Override
            public String get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        List<String> b = new ArrayList<>();

        System.out.println(5>>1);

        int i =0;
        i++;
        ++i;
        System.out.println(i);


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("name");
        linkedList.push("a");
        linkedList.offer("1");
        linkedList.poll();
        linkedList.pop();//删除元素
        linkedList.get(1);//不删除元素

        linkedList.hashCode();


    }


}
