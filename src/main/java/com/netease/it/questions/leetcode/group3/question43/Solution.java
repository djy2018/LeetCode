package com.netease.it.questions.leetcode.question43;

/**
 * Created by dujiayong on 2020/2/5.
 */
public class Solution {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        int carray = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1 - i; j > 0; j--) {
                sb.append("0");
            }

            int n2 = num2.charAt(i) - '0';
            for (int k = num1.length() - 1; k >= 0 || carray != 0; k--) {
                int n1 = k < 0 ? 0 : num1.charAt(k) - '0';
                int sum = n1 * n2 + carray;
                sb.append(sum % 10);
                carray = sum / 10;
            }
            res = addStr(res, sb.reverse().toString());
        }
        return res;
    }

    public static String addStr(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int a = i < 0 ? 0 : (num1.charAt(i) - '0');
            int b = j < 0 ? 0 : (num2.charAt(j) - '0');
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "9", num2 = "9";
        String result = multiply(num1, num2);
        System.out.println("result=" + result);
    }
}
