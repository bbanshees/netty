package com.algorithm.normal;

import java.util.*;

/**
 * @description:
 * @author: Spike
 * @date: 2020-01-31 19:27
 **/

public class Test {


    public static void main(String[] args) {
        String[] contentArray = {"aab","ab","eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(splitArray(contentArray));
    }


    public static List<List<String>> splitArray(String[] contentArray) {
        Map<Set<String>, List<String>> map = new HashMap<>();
        for (String s : contentArray) {
            Set<String> set = new TreeSet<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {

                set.add(aChar + "");
            }
            List<String> stringList;
            if (!map.containsKey(set)) {

                if(set.size() != s.length()){
                    stringList = map.get(set);
                    stringList.add(s);
                    continue;
                }

                stringList = new ArrayList<>();
                stringList.add(s);
                map.put(set,stringList);
            } else {
                stringList = map.get(set);
                stringList.add(s);
            }
        }
        if(map.size() > 0){
            List<List<String>> result = new ArrayList<>();
            Set<Map.Entry<Set<String>, List<String>>> entry = map.entrySet();
            for (Map.Entry<Set<String>, List<String>> setListEntry : entry) {
                result.add(setListEntry.getValue());
            }
            return result;
        }

        return null;
    }


}
