package com.spike.jdkRead;

import java.lang.reflect.Method;
import java.net.InetAddress;



/**
 * super this 不能在static方法中使用
 */
/** 因为this代表的是调用这个函数的对象的引用,而静态方法是属于类的,不属于对象,静态方法成功加载后,对象还不一定存在
   在问题之前先讲super的用法：
   1.super的用法跟this类似，this代表对本类对象的引用，指向本类已经创建的对象；而super代表对父类对象的引用，指向父类对象；
   2.静态优先于对象存在；
   3.由上面的1.和2.知：因为静态优先于对象存在，所以方法被静态修饰之后方法先存在，
   而方法里面要用到super指向的父类对象，但是所需的父类引用对象晚于该方法出现，也就是super所指向的对象没有，当然就会出错。

   综上，静态方法中不可以出现super关键字。

   首先要明白对象和类的区别。 this和super是属于对象范畴的东西，而静态方法是属于类范畴的东西。
   所有的成员方法都有一个默认的的参数this(即使是无参的方法),只要是成员方法,编译器就会给你加上this这个参数如:
   Class A中
        void method1(){}实际上是这样的--------> void method1(A this)
        void method2(int x){}实际上是这样的--------> void method2(A this, int x)
   而静态方法与对象无关,根本不能把对象的引用传到方法中,所以不能用this

   在一个类中定义一个方法为static，则为静态方法，那就是说，无需本类的对象即可调用此方法，调用一个静态方法就是“类名.方法名”
*/
/**
 * @description: jdk read test
 * @author: Spike
 * @date: 2019-08-23 10:23
 **/
public class Read extends ReadParent {


    public static void main(String[] args) throws Exception {


        test10();


    }
    protected void t(){
        System.out.println("1");
    }

    private static void test10() throws CloneNotSupportedException {

        Read read = new Read();
        Read read1 = (Read) read.clone();

        ReadParent readParent = new ReadParent();
        readParent.setName("spike");
//        ReadParent readParent1 = (ReadParent) readParent.clone();
//        System.out.println(readParent1.toString());
    }

//    ==：
//       == 比较的是变量(栈)内存中存放的对象的(堆)内存地址，用来判断两个对象的地址是否相同，即是否是指相同一个对象。比较的是真正意义上的指针操作。
//       1、比较的是操作符两端的操作数是否是同一个对象。
//       2、两边的操作数必须是同一类型的（可以是父子类之间）才能编译通过。
//       3、比较的是地址，如果是具体的阿拉伯数字的比较，值相等则为true，如：int a=10 与 long b=10L 与 double c=10.0都是相同的（为true），因为他们都指向地址为10的堆。
//    equals：
//       equals用来比较的是两个对象的内容是否相等，由于所有的类都是继承自java.lang.Object类的，
//       所以适用于所有对象，如果没有对该方法进行覆盖的话，调用的仍然是Object类中的方法，而Object中的equals方法返回的却是==的判断。

//    另外，"=="比"equals"运行速度快,因为"=="只是比较引用。
    private static void test9() {
        ReadParent r1 = new ReadParent();
        ReadParent r2 = new ReadParent();

        String s1 = "a";
        String s2 = "a";
        String s3 = s1;
        String s4 = new String("a");
        String s44 = new String("a");

        String s5 = s1 + s2;
        String s6 = "aa";

        String s7 = "helloworld";
        final String s8 = "hello";
        final String s9 = "world";
        String s10 = s8 + s9;

        int a = 10;
        long b = 10L;
        double c = 10D;
        //常量池里面存放基本类型常量和字符串常量
        //存放在常量池中
        System.out.println(a == b);//1
        System.out.println(a == c);//1
        System.out.println(b == c);//1
        // 新建的两个对象，地址不同，所以==为false。又由于没有指定父类，且没有重写equals方法，所以统一父类为object
        // 使用object的equals方法（object的equals是：==），所以为false。
        System.out.println(r1 == r2);//0
        System.out.println(r1.equals(r2));//0
        //都是去常量池中寻找值，如果存在就把引用指向那个地址，所以是相等的
        System.out.println(s1 == s2);//1
        System.out.println(s1 == s3);//1
        System.out.println(s2 == s3);//1
        System.out.println(s4 ==s44);//0
        //使用new 创建一个新的对象，不论常量池中是否已经存在该字符串，也创建新的对象存放在堆中，所以地址不相等，不一致
        System.out.println(s1 == s4);//0

//      s5由两个String变量相加得到，不能再编译时就确定下来，不能直接引用常量池中的"helloworld"对象，而是在堆内存中创建一个新的String对象并由s5指向
//      所以s5==s6为false
        System.out.println(s5 == s6);//0
//      * s8与s9被final修饰为宏变量，不可更改，编译器在程序使用该变量的地方直接使用该变量的值进行替代，所以s10的值在编译的时候就为"helloworld"
//      * 指向常量池中的"helloworld"对象
//      * 所以s7==s10为true
        System.out.println(s7 == s10);//1

    }

    public static<T> T test8(String b) {
        Number a = 9222832333647321312L;
        System.out.println(a.getClass());
        return null;
    }

    private static void test7() throws Exception {
        String a = InetAddress.getLocalHost().getHostAddress();//如果需要得到局域网ip请更改hosts文件
        System.out.println(a);

    }


    private static void test6() {
        int a = 1432;
        int b = 8;
        //（使用位运算代替乘除取模，需要算子为2 的幂次，这样可以简单的使用 移位、与、或、非、异或 来运算）

        System.out.println(toBinary(a, 20));
        //取模
        System.out.println(a % b);
        System.out.println(a & (b - 1)); // 末3位的数就是不能被8除掉的数，与运算，得到末三位的数，因为之前的数都因为7=>0111，被0所屏蔽了
        //除法
        System.out.println(a / b);
        System.out.println(a >> 3); //右移3位是因为8是2的3次方，从而去除掉不能被8除掉的数。
        //乘法
        System.out.println(a * b);
        System.out.println(a << 3);
    }

    private static void nomal() {
        long start = System.currentTimeMillis();
        long a = 100;
        for (int i = 0; i < 1000000000; i++) {
            a *= 2;
            a /= 2;
        }
        System.out.println("nomal total used:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    private static void bit() {
        long start = System.currentTimeMillis();
        long a = 100;
        for (int i = 0; i < 1000000000; i++) {
            a <<= 1;
            a >>= 1;
        }
        System.out.println("bit total used:"
                + (System.currentTimeMillis() - start) + "ms");
    }

    private static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return bs.substring(1);
    }

    private static void test5() {
        int i = 33;
        System.out.println(i);
        System.out.println(toBinary(i, 30));
        int x = (i << 5) - i;
        System.out.println(x);
        System.out.println(toBinary(x, 30));
        System.out.println(i * 31); // i * 32 - i * 1 == i * ( 32 -1 ) == i * 31
        System.out.println((i << 5) - i); // 左移五位相当于 （i * 2 的 5 次方）; (i << 5) - i == i * ( 2 * 2 * 2 * 2 * 2 ) - i
        int y = (x >> 5);
        System.out.println(toBinary(y, 30));
        System.out.println(((x + i) >> 5));
    }

    private static void test4() {
        Object o = new Object();
        System.out.println(o.hashCode());

        char[] a = {'a', 'b'};
        int b = hashCode1(a, 0);
        System.out.println(b);
    }

    private static int hashCode1(char[] value, int hash) {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

    private static void test3() {
        int a = 10 % (2 * 2 * 2);
        int b = 10 & ((2 << (3 - 1)) - 1);
        System.out.println(a + "," + b);
        System.out.println(10 & 7);

        System.out.println(2 * 2 * 2);
        System.out.println(2 << 2);
    }


    private static void test2() throws Exception {
        Read read = new Read();
        Class<?> c = Class.forName("com.spike.jdkRead.Read");
        Object o = c.newInstance();
        Method[] m = c.getDeclaredMethods();
        for (Method me : m) {
            System.out.println(me);
        }
        Method[] mm = c.getMethods();
        for (Method me : mm) {
            System.out.println(me);
        }


        Method pm = c.getDeclaredMethod("test", String.class);

        pm.setAccessible(true);

        pm.invoke(o, "1");
        Object r = new Read();
        System.out.println(read.getClass());
        System.out.println(r.getClass());
        System.out.println(Read.class);
    }

    private static void test(String s) throws Exception {
        System.out.println("===================");
        Class<?> c = Class.forName("com.spike.jdkRead.Read");
        Object o = c.newInstance();
        Method pm = c.getDeclaredMethod("test3");
        pm.setAccessible(true);
        pm.invoke(o);
        System.out.println(s);
    }


}
