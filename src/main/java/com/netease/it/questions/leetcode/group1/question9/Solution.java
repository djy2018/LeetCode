package com.netease.it.questions.leetcode.group1.question9;

/**
 * @author dujiayong
 * @date 2019/03/18
 **/
public class Solution {

    /**
     * 方法1
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String converseStr = converse(str);
        return str.equals(converseStr);
    }

    public static String converse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String left = str.substring(0, str.length() / 2);
        String right = str.substring(str.length() / 2, str.length());
        return converse(right) + converse(left);
    }

    /**
     * 方法2
     *
     * @param x
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }

    public static void main(String[] args) {
        int x = 12321;
        boolean palindrome = isPalindrome2(x);
        System.out.println("result=" + palindrome);
    }


}
