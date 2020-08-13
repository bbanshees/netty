package com.spike.jvm.c2;

import java.net.URL;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-01 13:26
 **/

public class ClassloaderTest {
    static int i = 0;

    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassloader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassloader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取扩展类加载器
        ClassLoader extClassLoader = systemClassloader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@7cc355be//

        //获取其上层：获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);//null

        //对于用户自定义来说：使用系统类加载器进行加载
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //对于string：使用引导类加载器进行加载==>java的核心类库都是使用引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);//null

        System.out.println("***********启动类加载器*************");
        //获取BootstrapClassLoader能够加载的api的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        System.out.println("***********扩展类加载器*************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String extDir : extDirs.split(":")) {
            System.out.println(extDir);
        }


    }
}

