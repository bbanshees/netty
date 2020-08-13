package com.spike.jvm.c8;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: gc test
 * @author: Spike
 * @date: 2020-07-22 15:46
 **/

public class GCtest {

    GCtest() {
        System.out.println("构造方法执行");
    }
    static {
        System.out.println("静态代码块执行");
    }


    {
        System.out.println("非静态代码块执行");
    }


    public static void main(String[] args) {
//        int i = 0 ;
//
//        try {
//            List<String> list = new ArrayList<>();
//            String str = "atguigu.com";
//            while(true){
//                list.add(str);
//                str = str + str;
//                i++;
//            }
//        }catch (Throwable t){
//            t.printStackTrace();
//            System.out.println("遍历次数："+ i);
//        }
        GCtest gCtest = new GCtest();
        System.out.println("main 方法执行");
        System.out.println( );
    }


}
class Order{

    public void test(){
        final int a = 0 ;
    }
}
