package com.netease.it.questions.leetcode.question13;

/**
 * 将古罗马字符转换成整型
 * @author dujiayong
 * @date 2019/03/28
 **/
public class Solution {

    public static int romanToInt(String s) {
        int sum = 0;
        if (s.contains("IV") || s.contains("IX")) {
            sum -= 2;
        }
        if (s.contains("XL") || s.contains("XC")) {
            sum -= 20;
        }
        if (s.contains("CD") || s.contains("CM")) {
            sum -= 200;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'I'){
                sum += 1;
            }
            if (chars[i] == 'V') {
                sum += 5;
            }
            if (chars[i] == 'X') {
                sum += 10;
            }
            if (chars[i] == 'L') {
                sum += 50;
            }
            if (chars[i] == 'C') {
                sum += 100;
            }
            if (chars[i] == 'D') {
                sum += 500;
            }
            if (chars[i] == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int result = romanToInt(s);
        System.out.println("result=" + result);
    }
}
