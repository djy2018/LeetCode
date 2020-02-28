package com.netease.it.questions.nowcoder.offer.question8;

/**
 * Created by dujiayong on 2020/2/7.
 */
public class Solution {

    public static int JumpFloor(int target) {
        if(target <= 2){
            return target;
        }

        int pre2 = 1,pre1=2;
        for(int i=3;i<=target;i++){
            int cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int count = JumpFloor(5);
        System.out.println("count=" + count);
    }


}
