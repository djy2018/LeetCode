package com.netease.it.questions.leetcode.question20;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author dujiayong
 * @date 2019/04/08
 **/
public class Solution {

    /**
     * 利用栈先进后出特性
     * @param s
     * @return
     */
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

    /**
     * 方法一的变形
     * @param str
     * @return
     */
    public static boolean isValid2(String str){
        Stack<Character> stack = new Stack<>();
        for(char c:str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(!stack.isEmpty() && leftOf(c) == stack.pop()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static Character leftOf(char c){
        if(c == ')'){
            return '(';
        }
        if(c == '}'){
            return '{';
        }
        if(c == ']'){
            return '[';
        }
        return null;
    }


    public static void main(String[] args) {
        String s = "({[]}";
        boolean valid = isValid(s);
        System.out.println("valid=" + valid);
    }
}
