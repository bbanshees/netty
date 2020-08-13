package com.spike.test;

/**
 * @description: 小说类
 * @author: Spike
 * @date: 2020-05-07 11:10
 **/

public class NovelBook implements IBook{


    //书籍名称
    private String name;
    //书籍价格
    private String price;

    public NovelBook(String name, String price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPrice() {
        return this.price;
    }
}
