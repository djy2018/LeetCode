package com.netease.it.questions.算法思维.浅谈递归II;

import java.util.Collections;
import java.util.Vector;

/**
 * 给一个正整数n，返回所有包含n对括号的合法括号序列
 *
 * @author dujiayong
 * @date 2020/9/1 20:30
 */
public class RecursionParenthesis {

    public static Vector<String> generateParenthesis(int n) {
        if (n == 0) {
            Vector<String> vector = new Vector<>();
            vector.add("");
            return new Vector<>(Collections.singletonList(""));
        }

        Vector<String> ans = new Vector<>();
        for (int i = 0; i < n; i++) {
            for (String left : generateParenthesis(i)) {
                for (String right : generateParenthesis(n - i - 1)) {
                    ans.add("(" + left + ")" + right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        Vector<String> result = generateParenthesis(n);
        System.out.println("result=" + result.toString());
    }

}
