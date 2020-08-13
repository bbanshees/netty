package com.spike.netty.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIoClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long time = System.currentTimeMillis();

        long transferCount = fileChannel.transferTo(0,fileChannel.size(),socketChannel);//这个方法 用到了零拷贝

        System.out.println("transferCount:" + transferCount + "time: "+ (System.currentTimeMillis()-time));

        fileChannel.close();
    }

}
