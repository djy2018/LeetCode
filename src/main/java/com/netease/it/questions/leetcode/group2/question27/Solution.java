package com.netease.it.questions.leetcode.group2.question27;

/**
 * @author dujiayong
 * @date 2019/04/17
 **/
public class Solution {

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int id = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[id++] = nums[i];
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int i = removeElement(nums, 2);
        System.out.println("len=" + i);
    }


}
