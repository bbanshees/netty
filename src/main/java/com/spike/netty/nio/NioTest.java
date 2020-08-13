package com.spike.netty.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioTest {
    private static Map<String, SocketChannel> clientMap = new HashMap<>(); //在服务端记录维护客户端的连接信息

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost", 8899));


        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);// 将channel对象注册到selector中(只将serverSocketChannel 注册到了selector中)


        while (true) {
            try {
                selector.select();// 进行阻塞，返回它所关注的事件的数量
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();//返回与事件关联的channel对象
                selectionKeySet.forEach(selectionKey -> {
                    final SocketChannel client;


                    try {
                        if (selectionKey.isAcceptable()) {// 连接进来的channel 由 accept 状态 转换成一个新的 channel：read 状态
                            ServerSocketChannel sSC = (ServerSocketChannel) selectionKey.channel(); //ServerSocketChannel起到建立连接的作用
                            client = sSC.accept();
                            client.configureBlocking(false);
                            client.register(selector, SelectionKey.OP_READ);//此时，selector上面已经注册了两个 channel对象；
                                                                            // ServerSocketChannel 关注连接事件

                                                                            // SocketChannel 关注数据读取事件
                            String key = "[" + UUID.randomUUID().toString() + "]";
                            clientMap.put(key,client); // 由于主程序是死循环，一直监听进来的channel，所以可以异步获取到分别连接的channel
                                                       // 并且将连接过来的channel都放到map中


                        }else  if(selectionKey.isReadable()){//监听 新转换的 read的 channel（可能有多个（因为不断有连接进来））
                            client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                            int count = client.read(readBuffer);

                            if(count > 0){
                                readBuffer.flip();
                                Charset charset = Charset.forName("UTF-8");
//                                new String (readBuffer);
                                String receivedMessage = (charset.newDecoder().decode(readBuffer).asReadOnlyBuffer()).toString();
//                                String receivedMessage =

                                System.out.println(client+":"+receivedMessage);



                                String senderKey = null;

                                for(Map.Entry<String, SocketChannel> entry : clientMap.entrySet()){ //拿到当前的client（socketChannel）的 key
                                    if(client == entry.getValue()){
                                        senderKey = entry.getKey();
                                        break;
                                    }

                                }

                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()){ //遍历整个clientMap 去发信息
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer writeBuffer =   ByteBuffer.allocate(1024);
                                    if( client != value){// 给与当前不一致的 key的channel发信息
                                        writeBuffer.put((senderKey + ":" + receivedMessage).getBytes());//将数据放至buffer中叫读，从buffer中将数据拿出来叫写
                                        writeBuffer.flip();
                                        value.write(writeBuffer);
                                    }else{
                                        continue;
                                    }
                                }
                            }

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                });
                selectionKeySet.clear();


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
