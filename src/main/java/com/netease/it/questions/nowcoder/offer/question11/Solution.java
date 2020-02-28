package com.netease.it.questions.nowcoder.offer.question11;

import java.util.Stack;

/**
 * Created by dujiayong on 2020/2/7.
 */
public class Solution {

    public static void reOrderArray(int [] array) {
        Stack<Integer> oddStack = new Stack<>();
        Stack<Integer> evenStack = new Stack<>();

        for(int i=array.length-1;i>=0;i--){
            if(array[i]%2==0){
                evenStack.push(array[i]);
            }else{
                oddStack.push(array[i]);
            }
        }

        int oddSize = oddStack.size();
        for(int i=0;i<oddSize;i++){
            array[i] = oddStack.pop();
        }
        int evenSize = evenStack.size();
        for(int i=0;i<evenSize;i++){
            array[oddSize+i] = evenStack.pop();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        reOrderArray(array);
        System.out.println("end...");
    }

}
