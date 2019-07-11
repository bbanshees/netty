package com.spike.netty;

import io.netty.util.NettyRuntime;
import io.netty.util.internal.SystemPropertyUtil;

import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class Test extends Father<Test, ServerSocketChannel> implements Executor {

    volatile String name;
    volatile String id;
    AtomicInteger atomicInteger;
//    ServerSocketChannel serverSocketChannel;


    Test(Class<?> type) {
        System.out.println(type);
    }
    Test(){}

    public Test aVoid() {
        System.out.println(name + ":" + id);
        return this;

    }

    public Test aVoid2() {
        System.out.println(atomicInteger + ":" + serverSocketChannel);
        return this;
    }


    public static void main(String[] args) throws Exception {




        int result = Math.max(1, SystemPropertyUtil.getInt(
                "io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost",8899));
        AtomicInteger a = new AtomicInteger(1);
        Test t = new Test(String.class);

        Test3 test3 =new Test3(Channel.class);

        test3.testtt(ServerSocketChannel.class);



        t.group(a, serverSocketChannel).aVoid2();
        t.group("a", "1").aVoid().aVoid2();
//        t.group("", "1").aVoid();
        System.out.println(t.get());
        System.out.println(t);

        System.out.println(result);
        System.out.println(t.getChannel());
        Test2 test2 = new Test2();
        test2.group(serverSocketChannel);
        System.out.println(t.getChannel());
        test2.group(serverSocketChannel);

    }

    public Test get() {
        return new Test(getClass());
    }
    public ServerSocketChannel getChannel(){
        return serverSocketChannel;
    }

    @Override
    public void execute(Runnable runnable) {

    }

    public Test group(AtomicInteger atomicInteger, ServerSocketChannel serverSocketChannel) {
        super.group(serverSocketChannel);
        this.atomicInteger = atomicInteger;
//        this.serverSocketChannel = serverSocketChannel;
        return this;

    }


    public Test group(String name, String id) {
        if (name == null) {
            throw new NullPointerException("name");
        }
        if (this.name != null) {
            throw new IllegalStateException("name already exits");
        }
        if (id == null) {
            throw new NullPointerException("id");
        }
        if (this.id != null) {
            throw new IllegalStateException("id already exits");
        }
        this.name = name;
        this.id = id;
        return this;

    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }

        throw new IllegalStateException("21");

    }

}
