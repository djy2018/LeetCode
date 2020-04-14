package com.netease.it.questions.leetcode.group2.question31;

/**
 * @author dujiayong
 * @date 2019/04/30
 **/
public class Solution {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 找到第一个不再递增的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        // 如果到了最左边，就直接倒置输出
        if (i < 0) {
            reverse(nums, 0);
            return;
        }

        //找到刚好大于nums[i]的位置
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        // 交换
        swap(nums, i, j);
        // 利用倒置进行排序
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        System.out.println("nums=" + nums.toString());
    }

}
