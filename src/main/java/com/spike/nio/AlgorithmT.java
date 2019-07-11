package com.spike.nio;

import java.util.*;

public class AlgorithmT {

    public final int value;

    public AlgorithmT(int value){
        this.value = value;
    }

    public AlgorithmT(AlgorithmT original){
        this.value = original.value;
    }


    public static void main(String[] args) {
        String a = new String("a");
        AlgorithmT b = new AlgorithmT(new AlgorithmT(2));
        System.out.println(b.value);

//        int nums[] = {2,7,11,15};
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(2);
//        a.add(7);
//        a.add(11);
//        a.add(15);
//        System.out.println(a.contains(7));
//        System.out.println(Arrays.asList(nums).contains(7));
//        System.out.println(Arrays.asList(nums));

//        test();
    }

    public static void test() {
        int nums[] = {-2,0,1,1,2};
        Set<String> b = new HashSet();
        ArrayList<Integer> a = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (i == k) {
                        continue;
                    } else if (i == j) {

                        continue;
                    } else if (j == k) {

                        continue;
                    } else if (nums[i] + nums[j] + nums[k] == 0) {

                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                        a.sort(Integer::compareTo);
                        String str = a.get(0)+","+a.get(1)+","+a.get(2);
                        b.add(str);
                        a.clear();
                    }
                }
            }
        }
        for (String o : b) {
            System.out.println(o);
        }


    }
}

