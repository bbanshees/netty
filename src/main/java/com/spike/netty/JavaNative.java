package com.spike.netty;

public class JavaNative {
    static {
        System.loadLibrary("spikelib.jnilib"); // hello.dll (Windows) or libhello.so (Unixes)
    }

    // Native method declaration
    private native void sayHello();

    // Test Driver
    public static void main(String[] args) {
        new JavaNative().sayHello(); // Invoke native method
    }

}
