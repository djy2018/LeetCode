package com.netease.it.questions.leetcode.question16;

import java.util.Arrays;

/**
 * @author dujiayong
 * @date 2019/03/30
 **/
public class Solution {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int maxCloLen = 0;
        int minSum = nums[0] + nums[1] + nums[2];
        int maxSum = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        if (Math.abs(maxSum - target) > Math.abs(target - minSum)) {
            maxCloLen = Math.abs(target - minSum);
        } else {
            maxCloLen = Math.abs(maxSum - target);
        }

        for (int i = 0; i < maxCloLen + 1; i++) {
            Integer res = threeSum(nums, target + i);
            if (res == null) {
                res = threeSum(nums, target - i);
                if (res == null) {
                    continue;
                }
            }
            return res;
        }
        return 0;
    }

    public static Integer threeSum(int[] num, int target) {
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum + target) {
                        return num[i] + num[lo] + num[hi];
                    } else if (num[lo] + num[hi] < sum + target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,-1,-1,3};
        int target = 3;
        int res = threeSumClosest(nums, target);
        System.out.println("result=" + res);
    }
}
