package com.netease.it.questions.leetcode.group2.question35;

/**
 * @author dujiayong
 * @date 2019/08/26
 **/
public class Solution {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }

        int mid = nums.length / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            if (mid < nums.length - 1) {
                int[] nums2 = new int[nums.length-(mid+1)];
                System.arraycopy(nums,mid+1,nums2,0,nums.length-(mid+1));
                return mid + 1 + searchInsert(nums2,target);
            } else {
                return mid + 1;
            }
        }else{
            int[] nums2 = new int[mid];
            System.arraycopy(nums,0,nums2,0,mid);
            return searchInsert(nums2,target);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,7};
        int i = searchInsert(nums, 0);
        System.out.println("result=" + i);
    }

}
