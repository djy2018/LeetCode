package com.netease.it.questions.question14;

/**
 * Created by dujiayong on 2019/3/28.
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        // 字符数组中最短字符
        String minLenStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLenStr.length()) {
                minLenStr = strs[i];
            }
        }

        for (int i = 0; i < minLenStr.length(); i++) {
            for (int start = 0, end = minLenStr.length() - i; end < minLenStr.length() + 1; start++, end++) {
                // 子串
                String subStr = minLenStr.substring(start, end);
                if(isContainSubStr(strs,subStr)) return subStr;
            }
        }
        return "";
    }

    private static boolean isContainSubStr(String[] strs, String subStr) {
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(subStr) != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"ca","a"};
        String s = longestCommonPrefix(strs);
        System.out.println("result==" + s);
    }
}
