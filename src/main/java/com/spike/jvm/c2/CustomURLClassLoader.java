package com.spike.jvm.c2;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-02 15:03
 **/

public class CustomURLClassLoader extends URLClassLoader {
    public CustomURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public CustomURLClassLoader(URL[] urls) {
        super(urls);
    }

    public CustomURLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }
}
