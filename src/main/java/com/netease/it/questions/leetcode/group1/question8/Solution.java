package com.netease.it.questions.leetcode.group1.question8;

/**
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Therefore INT_MIN (−231) is returned.
 *
 * @author dujiayong
 * @date 2019/03/18
 **/
public class Solution {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        char c = str.charAt(0);
        boolean isNegative = false;
        if ("-".toCharArray()[0] == c || "+".toCharArray()[0] == c) {
            isNegative = "-".toCharArray()[0] == c;
            if (str.length() > 1) {
                char nextChar = str.charAt(1);
                if (nextChar < 48 || nextChar > 57) {
                    return 0;
                } else {
                    return subNumber(str.substring(1, str.length()), isNegative);
                }
            } else {
                return 0;
            }
        } else if (c < 48 || c > 57) {
            return 0;
        } else {
            return subNumber(str, isNegative);
        }
    }

    public static int subNumber(String str, boolean isNegative) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 48 || c > 57) {
                break;
            } else {
                int mod = Integer.valueOf(String.valueOf(c));
                int num = 0;
                if (i > 0) {
                    num = Integer.valueOf(builder.toString());
                }
                if (isNegative) {
                    if (-num < Integer.MIN_VALUE / 10 || (-num == Integer.MIN_VALUE / 10 && mod >= 8)) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && mod > 7)) {
                        return Integer.MAX_VALUE;
                    }
                }
                builder.append(c);
            }
        }
        return isNegative ? -Integer.valueOf(builder.toString()) : Integer.valueOf(builder.toString());
    }

    public static void main(String[] args) {
        String str = "+1";
        int result = myAtoi(str);
        System.out.println(str + "\n" + result);
    }

}
