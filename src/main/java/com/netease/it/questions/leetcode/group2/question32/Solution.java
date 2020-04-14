package com.netease.it.questions.leetcode.group2.question32;

/**
 * @author dujiayong
 * @date 2019/04/30
 **/
public class Solution {

    /**
     * 动态规划，网址：https://leetcode.windliang.cc/leetCode-32-Longest-Valid-Parentheses.html
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = ")()())";
        int i = longestValidParentheses(s);
        System.out.println("result=" + i);
    }

}
