package com.netease.it.questions.group1.question7;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * @author dujiayong
 * @date 2019/03/15
 **/
public class Solution {

    /**
     * 法1:it't wrong, eg: 10900000 ==> 91 , error
     *
     * @param x
     * @return
     */
    public static Integer reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        if (x / 10 == 0) {
            return isNegative ? -x : x;
        } else {
            Integer result = null;
            try {
                result = Integer.valueOf(String.valueOf(x % 10) + String.valueOf(reverse(x / 10)));
            } catch (NumberFormatException e) {
                return 0;
            }
            return isNegative ? -result : result;
        }
    }

    /**
     * 法2:int -> string , then reverse str ,finally convert reversed str to int
     *
     * @param x
     * @return
     */
    public static Integer reverse2(int x) {
        boolean isNegative = false;
        if (x < 0) {
            x = -x;
            isNegative = true;
        }
        String s = String.valueOf(x);
        String reverseStr = reverseStr(s);
        int result;
        try {
            result = Integer.valueOf(reverseStr);
        } catch (NumberFormatException e) {
            result = 0;
        }
        return isNegative ? -result : result;
    }

    public static String reverseStr(String s) {
        if (s.length() == 1) {
            return s;
        }
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2, s.length());
        return reverseStr(right) + reverseStr(left);
    }

    /**
     * method 3:use stack, pop the last digit of the integer
     * <p>
     * pop = x % 10
     * x = x/10
     * <p>
     * temp = rev * 10 + pop
     * rev = temp
     *
     * @param x
     * @return
     */
    public static Integer reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String[] args) {
        int x = 1534236469;
//        int x = 12345;
        Integer reverse = reverse3(x);
        System.out.println(x + "\n" + reverse);
    }
}
