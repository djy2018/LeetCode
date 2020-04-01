package com.netease.it.questions.group1.question18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dujiayong
 * @date 2019/04/04
 **/
public class Solution {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序数组
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length < 4){
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] subSum = new int[nums.length - 1];
            if (i == 0) {
                System.arraycopy(nums, 1, subSum, 0, nums.length - 1);
            }
            if (i == nums.length - 1) {
                System.arraycopy(nums, 0, subSum, 0, nums.length - 1);
            }
            if (i > 0 && i < nums.length - 1) {
                System.arraycopy(nums, 0, subSum, 0, i);
                System.arraycopy(nums, i + 1, subSum, i, nums.length - i - 1);
            }

            threeSum(subSum, target - nums[i], nums[i], res);
        }

        return res;
    }

    public static void threeSum(int[] num, int target, int cur, List<List<Integer>> list) {
        // 遍历可能存在的开头元素
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum + target) {
                        List<Integer> result = Arrays.asList(cur,num[i], num[lo], num[hi]);
                        Collections.sort(result);
                        if(!list.contains(result)){
                            list.add(result);
                        }
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
                        }
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum + target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{-3,-1,0,2,4,5};
        int target = 2;
        List<List<Integer>> lists = fourSum(num, target);
        System.out.println("result:" + lists.toString());
    }
}
