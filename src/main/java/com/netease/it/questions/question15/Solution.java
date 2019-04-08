package com.netease.it.questions.question15;

import java.util.*;

/**
 * @author dujiayong
 * @date 2019/03/29
 **/
public class Solution {

    /**
     * 暴力解决，Time is out
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        boolean isExistZero = false;
        List<Integer> negativeNums = new ArrayList<>();
        List<Integer> positiveNums = new ArrayList<>();
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveNums.add(nums[i]);
            } else if (nums[i] < 0) {
                negativeNums.add(nums[i]);
            } else {
                isExistZero = true;
                zeroCount++;
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        if (zeroCount >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        for (int i = 0; i < positiveNums.size(); i++) {
            int posNum = positiveNums.get(i);
            for (int j = 0; j < negativeNums.size(); j++) {
                int negNum = negativeNums.get(j);
                if (isExistZero && posNum == Math.abs(negNum)) {
                    List<Integer> list = Arrays.asList(negNum, 0, posNum);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                } else if (Math.abs(negNum) > posNum) {
                    int otherPosNum = Math.abs(negNum) - posNum;
                    // 2元素是否相等
                    boolean flag = false;
                    if (otherPosNum == posNum) {
                        flag = true;
                    }
                    if (isExistNum(otherPosNum, positiveNums, flag)) {
                        List<Integer> list = posNum > otherPosNum ? Arrays.asList(negNum, otherPosNum, posNum) : Arrays.asList(negNum, posNum, otherPosNum);

                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                } else {
                    int otherNegNum = -(posNum - Math.abs(negNum));
                    boolean flag = false;
                    if (otherNegNum == negNum) {
                        flag = true;
                    }
                    if (isExistNum(otherNegNum, negativeNums, flag)) {
                        List<Integer> list = negNum > otherNegNum ? Arrays.asList(otherNegNum, negNum, posNum) : Arrays.asList(negNum, otherNegNum, posNum);

                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isExistNum(Integer num, List<Integer> list, boolean flag) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), num)) {
                count++;
            }
        }
        if (flag) {
            return count >= 2;
        } else {
            return count >= 1;
        }
    }

    /**
     * Step1:针对整型数组排序
     * Step2:遍历可能存在三元组中的第一个元素
     * Step3:从遍历元素的下一个元素开始-low，结束为止作为end，双向求和比较。注意：如果遇到重复元素请跳过，这样在没有使用Set情况下不会出现重复元素
     *
     * @param nums
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[lo], nums[hi]);
                    if(!res.contains(list)){
                        res.add(list);
                    }
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] > sum) {
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum3(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi-1]) {
                            hi--;
                        }
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum3(nums);
        System.out.println("result==" + "\n" + lists);
    }
}
