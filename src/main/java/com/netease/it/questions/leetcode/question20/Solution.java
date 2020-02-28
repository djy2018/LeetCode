package com.netease.it.questions.leetcode.question20;

import java.util.Stack;

/**
 * @author dujiayong
 * @date 2019/04/08
 **/
public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "({[]}";
        boolean valid = isValid(s);
        System.out.println("valid=" + valid);
    }
}
