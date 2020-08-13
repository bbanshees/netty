package com.spike.jvm.c2;

import java.io.FileNotFoundException;

/**
 * @description: 自定义加载器
 * @author: Spike
 * @date: 2020-07-02 11:26
 **/

public class CustomClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try{
            byte[] res = getClassFromCustomPath(name);
            if(res == null){
                throw new FileNotFoundException();

            }else {
                return defineClass(name,res,0,res.length);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);

    }

    private byte[] getClassFromCustomPath(String name){
        //从自定义路径中加载类
        //如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作。
        return null;
    }

//------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try{
            Class<?> clazz = Class.forName("one",true,customClassLoader);
            Object o = clazz.newInstance();
            System.out.println(o.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
