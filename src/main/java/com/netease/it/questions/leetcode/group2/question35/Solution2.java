package com.netease.it.questions.leetcode.group2.question35;

/**
 * @author dujiayong
 * @date 2019/08/26
 **/
public class Solution2 {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;

        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7};
        int i = searchInsert(nums, 6    );
        System.out.println("result=" + i);
    }

}
