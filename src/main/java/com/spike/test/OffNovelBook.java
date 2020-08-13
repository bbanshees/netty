package com.spike.test;

/**
 * @description: 打折商品
 * @author: Spike
 * @date: 2020-05-07 11:12
 **/

public class OffNovelBook extends NovelBook{
    public OffNovelBook(String name, String price) {
        super(name, price);
    }
    @Override
    public String getPrice(){
        //原价
        String price = super.getPrice();
        return "";
    }

}
