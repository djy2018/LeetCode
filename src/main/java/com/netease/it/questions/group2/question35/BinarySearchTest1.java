package com.netease.it.questions.group2.question35;

/**
 * @author dujiayong
 * @date 2019/08/26
 **/
public class BinarySearchTest1 {

    public int search(int[] nums, int target) {
        int len = nums.length;

        if (nums.length < 1) {
            return -1;
        }

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


}
