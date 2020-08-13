package com.spike.jdkRead.juc;

/**
 * @description:
 *
 * 1, 函数式编程 有且仅有一个方法
 *
 *
 *      拷贝中括号，写死右箭头，落地大括号
 *      @FunctionalInterface
 *      default
 *      static
 *
 * @author: Spike
 * @date: 2020-08-03 16:42
 **/

public class LambdaTest {

    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        };
        foo.sayHello();


        Foo foo1 = () -> {
            System.out.println("hello foo1");
        };
        foo1.sayHello();
        Hoo hoo = (int x, int y) -> x + y;
        System.out.println(hoo.add(3, 4));
        System.out.println(foo.mul(3, 4));
        System.out.println(Foo.mul1(3, 4));

    }
}


@FunctionalInterface  // 用于标示函数式接口
interface Foo {
    public void sayHello();

    public default int mul(int x, int y) {
        return x * y;
    }

    public static int mul1(int x, int y){
        return x * y ;
    }
}

interface Hoo {
    public int add(int x, int y);
}
