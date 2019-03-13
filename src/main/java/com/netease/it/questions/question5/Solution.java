package com.netease.it.questions.question5;

/**
 * Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 思路:
 * get the longest common substring of the two string and compare the reversed the longest common substring with the original one
 * if same , then return the substring , otherwise continue
 *
 * @author dujiayong
 * @date 2019/03/13
 **/
public class Solution {

    public static String longestPalindrome(String strOne) {
        if (strOne == null || strOne.equals("")) {
            return strOne;
        }

        String strTwo = reverseStr(strOne);

        for (int i = 0; i < strOne.length(); i++) {
            for (int begin = 0, end = strOne.length() - i; end <= strOne.length(); begin++, end++) {
                String current = strOne.substring(begin, end);
                if (strTwo.contains(current)) {
                    if (current.equals(reverseStr(current))) {
                        return current;
                    }
                }
            }
        }
        return null;
    }

    public static String reverseStr(String str) {
        int length = str.length();
        if (length <= 1) {
            return str;
        }
        String left = str.substring(0, length / 2);
        String right = str.substring(length / 2, length);
        return reverseStr(right) + reverseStr(left);
    }

    public static void main(String[] args) {
        String str = "babad";
        String result = longestPalindrome(str);
        System.out.println(result);

    }

}
