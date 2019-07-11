package com.spike.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(socketAddress);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);//可有可无，因为该channel一定是阻塞的，根据之前的accept方法返回的结果来看，如果有selector的话
                                                        // 就一定要配置成非阻塞，因为新的channel需要注册到selector中，从而进行异步的操作
            int readCount = 0;
            while (-1 != readCount){
                try {
                    readCount = socketChannel.read(byteBuffer);
                }catch (Exception e){
                    e.printStackTrace();
                }

                byteBuffer.rewind();//将position归位，用于连续读，如果不归位，那每次在做read操作的时候，就会导致position的为止
            }

        }

    }


}
