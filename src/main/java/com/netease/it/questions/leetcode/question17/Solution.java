package com.netease.it.questions.leetcode.question17;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dujiayong
 * @date 2019/04/01
 **/
public class Solution {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] str = new String[]{"", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int number = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : str[number].toCharArray()) {
                    res.add(t+s);
                }
            }
        }
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("1");
        System.out.println("result=" + list.toString());
    }

}
