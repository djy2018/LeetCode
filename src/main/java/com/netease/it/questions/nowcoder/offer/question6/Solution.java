package com.netease.it.questions.nowcoder.offer.question6;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by dujiayong on 2020/2/6.
 */
public class Solution {

    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }

        for(int i = 0;i<array.length-1;i++){
            if(array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public int minNumberInRotateArray2(int [] array) {
        if(array.length == 0){
            return 0;
        }

        Arrays.sort(array);
        return array[0];
    }

    public int minNumberInRotateArray3(int [] array) {
        if(array.length == 0){
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<array.length;i++){
            queue.add(array[i]);
        }
        return queue.poll();
    }

}
