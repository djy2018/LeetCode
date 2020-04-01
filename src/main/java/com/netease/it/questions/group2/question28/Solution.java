package com.netease.it.questions.group2.question28;

/**
 * @author dujiayong
 * @date 2019/04/17
 **/
public class Solution {

    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }

        for (int lo = 0, hi = needle.length() - 1; hi < haystack.length(); lo++, hi++) {
            if (haystack.substring(lo, hi + 1).equals(needle)) {
                return lo;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = strStr("hello", "ll");
        System.out.println("result==" + i);
    }


}
