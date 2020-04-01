package com.netease.it.questions.group2.question33;

/**
 * @author dujiayong
 * @date 2019/08/21
 **/
public class Solution {

    public static int search(int[] nums, int target) {
        if (nums.length < 1) {
            return -1;
        }

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int start = 0;
        int mid = nums.length / 2;
        if (nums[start] == target) {
            return start;
        } else if (nums[start] > target) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[start]) {
                return rightHalfSearch(mid, nums, target);
            } else {
                if (nums[mid] < target) {
                    return rightHalfSearch(mid, nums, target);
                } else {
                    return leftHalfSearch(mid, nums, target);
                }
            }
        } else {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return leftHalfSearch(mid, nums, target);
            } else {
                if (nums[mid] > nums[start]) {
                    return rightHalfSearch(mid, nums, target);
                } else {
                    return leftHalfSearch(mid, nums, target);
                }
            }
        }
    }


    private static int rightHalfSearch(int mid, int[] nums, int target) {
        if (mid < nums.length - 1) {
            int[] nums2 = new int[nums.length - (mid + 1)];
            System.arraycopy(nums, mid + 1, nums2, 0, nums.length - (mid + 1));
            int result = search(nums2, target);
            if (result != -1) {
                return mid + 1 + result;
            }
        }
        return -1;
    }

    private static int leftHalfSearch(int mid, int[] nums, int target) {
        if (mid - 1 > 0) {
            int[] nums2 = new int[mid];
            System.arraycopy(nums, 0, nums2, 0, mid);
            return search(nums2, target);
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int index = search(nums, 8);
        System.out.println("result:" + index);
    }

}
