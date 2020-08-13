package com.algorithm.normal;

/**
 * @description: 快速排序
 * @author: Spike
 * @date: 2020-08-04 22:58
 **/

public class FastSort {

    public static void main(String[] args) {
        int[] array = {5,4,2,1,11,20};
        sort(array,0,5);
        for(int i :array){
            System.out.println(i);
        }
    }







    private static void sort(int[] array,int low,int high){


        if(low >= high ){
            return ;
        }

        int left = low;
        int right = high;

        int key = array[low];

        while( left < right ){
            while(left < right && key <= array[right]){
                right -- ;
            }
            array[left] =  array[right];

            while(left < right && key >= array[left]){
                left ++;
            }
            array[right] = array[left];


        }
        array[left] = key;

        sort(array,low,left-1);
        sort(array,left+1,high);

    }
}
