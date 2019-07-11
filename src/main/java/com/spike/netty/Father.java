package com.spike.netty;



import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;

public abstract class Father<B extends Father<B,C>,C extends Channel>{

    volatile public ServerSocketChannel serverSocketChannel;


    public B group(ServerSocketChannel serverSocketChannel){
        if(serverSocketChannel == null){
            throw new NullPointerException("serverSocketChannel");
        }
        if(this.serverSocketChannel != null ){
            throw new IllegalStateException("serverSocketChannel already exits");
        }
        this.serverSocketChannel = serverSocketChannel;

        Test3 test3 = new Test3<C>((Class<? extends C>) Channel.class);

        return (B) this;

    }
    public B testtt(Class<? extends C> clazz){
        new Test3<C>(clazz);
        new Test3<C>(Channel.class);
        new Test3<C>((Class<? extends C>) Channel.class);
        new Test3(Channel.class);
        new Test3(clazz);
        new Test3((Class<? extends C>) Channel.class);
        new Test3(getClass());

        return (B) this;
    }

    protected Father(){}



}
