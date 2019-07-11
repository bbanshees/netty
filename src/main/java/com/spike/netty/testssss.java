package com.spike.netty;

import com.google.gson.GsonBuilder;


public class testssss {
    public static String objectToGson(Object object){
        return new GsonBuilder().disableHtmlEscaping().create().toJson(object);
    }
    public static void main(String[] args) throws Exception{

//            Entity entity =new Entity();
//            entity.setId("1");
//            entity.setName("2");
//            String json = objectToGson(entity);
//            System.out.println(json);
//            ChannelMessageOuterClass.ChannelMessage ser =
//                    (com.aisino.model.ChannelMessageOuterClass.ChannelMessage) PbUtil.JsonToPb(json,ChannelMessageOuterClass.class);
//            if(ser.equals(null) )
//            {
//                System.out.println(1);
//            }else {
//                System.out.println("ser.object:"+ser);
//            }
//            System.out.println("ser:"+ser.toString());
//            System.out.println("-------------");
            System.out.println(new testssss().simpleClassName(null));
            new testssss().t();
    }
    public  String simpleClassName(Class<?> clazz) {
        String className = checkNotNull(getClass(), "clazz").getName();
        System.out.println(className);
        final int lastDotIdx = className.lastIndexOf(".");
        System.out.println(lastDotIdx);
        if (lastDotIdx > -1) {
            return className.substring(lastDotIdx + 1);
        }
        return className;
    }
    public static <T> T checkNotNull(T arg, String text) {
        if (arg == null) {
            throw new NullPointerException(text);
        }
        return arg;
    }
    public void t(){
        int i = 0;
        int j = 0 ;
        scan: for(;;){
            System.out.println(i);
            if (i == 1 || i == 2){
                print : for(;;){
                    j++;
                    System.out.println(i);
                    if(j == 2) {
                        continue print;
                    }
                    if(j == 3){
                        break print;
                    }
                    if(j == 4){
                        break scan;
                    }
                }
//                continue scan;

            }
            i++;
            System.out.println(i);
        }



    }
}
