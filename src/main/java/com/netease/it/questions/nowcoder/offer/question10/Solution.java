package com.netease.it.questions.nowcoder.offer.question10;

/**
 * Created by dujiayong on 2020/2/7.
 */
public class Solution {

    public double Power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }

        double result = 1.0d;
        int e = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= e; i++) {
            result *= base;
        }
        return exponent > 0 ? result : 1 / result;
    }

}
