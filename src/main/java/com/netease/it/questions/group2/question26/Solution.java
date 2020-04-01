package com.netease.it.questions.group2.question26;

/**
 * @author dujiayong
 * @date 2019/04/16
 **/
public class Solution {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 2) {
            return nums.length;
        }

        int id = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]){
                nums[id++] = nums[i];
            }
        }
        return id;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int count = removeDuplicates(nums);
        System.out.println("result=" + count);
    }
}
