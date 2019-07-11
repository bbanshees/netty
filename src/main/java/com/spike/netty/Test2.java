package com.spike.netty;

import java.nio.channels.ServerSocketChannel;

public class Test2 extends Father<Test2,ServerSocketChannel> {




    public Test2 group(ServerSocketChannel serverSocketChannel)  {

        try{
        super.group(serverSocketChannel);

            serverSocketChannel.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return this;

    }

    public static void main(String[] args) {
        String a = "apache-tomcat-7.0.90.tar.gz";
        String b = "tomcat_7.0.90_8082.zip";
        System.out.println(a.hashCode()+":"+b.hashCode());
    }



}
