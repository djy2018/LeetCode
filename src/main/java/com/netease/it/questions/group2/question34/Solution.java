package com.netease.it.questions.group2.question34;

/**
 * @author dujiayong
 * @date 2019/08/22
 **/
public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        int minIndex = searchIndex(nums, target, 1);
        int maxIndex = searchIndex(nums, target, 2);
        return new int[]{minIndex, maxIndex};
    }

    public static int searchIndex(int[] nums, int target, int flag) {
        if (nums.length < 1) {
            return -1;
        }

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int mid = nums.length / 2;

        if (nums[mid] > target) {
            return leftSearchIndex(mid, nums, target, flag);
        } else if (nums[mid] < target) {
            if (mid + 1 < nums.length) {
                int result = rightSearchIndex(mid, nums, target, flag);
                if (result != -1) {
                    return mid + 1 + result;
                }
            }
            return -1;
        } else {
            if (flag == 1) {
                int result = leftSearchIndex(mid, nums, target, flag);
                if (result != -1) {
                    return result;
                }
            }

            if (flag == 2) {
                int result = rightSearchIndex(mid, nums, target, flag);
                if (result != -1) {
                    return mid + 1 + result;
                }
            }

            return mid;
        }
    }

    private static int leftSearchIndex(int mid, int[] nums, int target, int flag) {
        int[] nums2 = new int[mid];
        System.arraycopy(nums, 0, nums2, 0, mid);
        return searchIndex(nums2, target, flag);
    }

    private static int rightSearchIndex(int mid, int[] nums, int target, int flag) {
        int[] nums2 = new int[nums.length - (mid + 1)];
        System.arraycopy(nums, mid + 1, nums2, 0, nums.length - (mid + 1));
        return searchIndex(nums2, target, flag);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8,8,8, 10};
        int[] results = searchRange(nums, 8);
        System.out.println("result=" + results.toString());
    }

}
