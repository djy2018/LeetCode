package com.netease.it.questions.nowcoder.offer.question9;

/**
 * Created by dujiayong on 2020/2/7.
 */
public class Solution {

    public static int JumpFloorII(int target) {
        int n = 1;
        for (int i = 2; i <= target; i++) {
            n = 2 * n;
        }
        return n;
    }

    public static void main(String[] args) {
        int count = JumpFloorII(4);
        System.out.println("count=" + count);
    }

}

