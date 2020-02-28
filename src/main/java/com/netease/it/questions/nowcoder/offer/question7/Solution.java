package com.netease.it.questions.nowcoder.offer.question7;

/**
 * Created by dujiayong on 2020/2/7.
 */
public class Solution {

    public static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }else if (n == 1 || n == 2) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int result = Fibonacci(6);
        System.out.println("result=" + result);
    }

}
