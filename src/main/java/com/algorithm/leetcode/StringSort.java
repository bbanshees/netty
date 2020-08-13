package com.algorithm.leetcode;

import java.util.*;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-15 10:05
 **/

public class StringSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

            String s = scanner.nextLine();
            System.out.println(test(s));
        }
    }

    private static String test(String s){
        char[] ch = s.toCharArray();
        Map<String,Integer> map = new TreeMap<>();
        for(char c : ch){
            if( (c>=97 && c<=122) || (c>= 65 && c<=90) || c ==32 ||(c>=48 && c<=57)){
                if(!map.containsKey(c+"")){
                    map.put(c+"",1);
                }else {
                    Integer integer = map.get(c + "");
                    map.put(c+"",integer+1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        new ArrayList<>(map.entrySet()).sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder result= new StringBuilder();
        for (Map.Entry<String, Integer> stringIntegerEntry : list) {
            result.append(stringIntegerEntry.getKey());
        }
        return result.toString();
    }
}
