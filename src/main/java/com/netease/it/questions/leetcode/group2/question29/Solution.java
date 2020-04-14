package com.netease.it.questions.leetcode.group2.question29;

/**
 * @author dujiayong
 * @date 2019/04/17
 **/
public class Solution {

    public static int divide(int dividend, int divisor) {
        int sign = 1;

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }


        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }

        long multiplication = ldivide(ldividend, ldivisor);
        if (multiplication > Integer.MAX_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign > 0 ? (int) multiplication : -(int) multiplication;
        }
    }

    public static long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }

        long sum = ldivisor;
        long multi = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multi += multi;
        }

        return multi + ldivide(ldividend - sum, ldivisor);
    }

    public static void main(String[] args) {
        int result = divide(-2147483648, -1);
        System.out.println("result==" + result);
    }

}
