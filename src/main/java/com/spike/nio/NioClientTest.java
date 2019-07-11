package com.spike.nio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClientTest {

    public static void main(String[] args)  {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("155.138.203.22",8899));

            Selector selector = Selector.open();
//          Selector selector1 =Selector.class.newInstance().provider().openSelector();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while(true){
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();

                for (SelectionKey selectionKey : selectionKeySet) {
                    if(selectionKey.isConnectable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();

                        if(client.isConnectionPending()){
                            client.finishConnect();//真正建立好连接

                            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

                            writeBuffer.put((LocalDateTime.now()+"connected successfully").getBytes());
                            writeBuffer.flip();
                            client.write(writeBuffer);

                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(()->{
                                while(true){
                                    try{
                                        writeBuffer.clear();
                                        InputStreamReader input = new InputStreamReader(System.in,"UTF-8");
                                        BufferedReader br = new BufferedReader(input);
                                        String sendMessage = br.readLine();

                                        writeBuffer.put(sendMessage.getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);

                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                }
                            });

                        }
                        client.register(selector,SelectionKey.OP_READ);
                    }else if(selectionKey.isReadable()){
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int count = client.read(readBuffer);
                        if( count > 0 ){


                            String receivedMessage = new String(  (readBuffer).array(), 0, count);

                            System.out.println(receivedMessage);
                        }


                    }

                }
                selectionKeySet.clear();

            }




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
