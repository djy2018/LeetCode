package com.netease.it.questions.算法思维.回溯算法.全排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dujiayong on 2020/4/11.
 */
public class Solution {

    private static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return res;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> list) {
        // 退出条件
        if (list.size() == nums.length) {
            // 注意：new LinkedList创建一个新的列表,保存到达决策树底层的路径
            res.add(new LinkedList<Integer>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }

            list.add(num);
            backtrack(nums, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = permute(nums);
        System.out.println("数组:" + Arrays.toString(nums) + "-全排列情况:" + list.toString());
    }

}
