package com.netease.it.questions.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dujiayong
 * @date 2019/04/10
 **/
public class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str = "";
        backtrace(list, str, 0, 0, n);
        return list;
    }

    public static void backtrace(List<String> list, String str, int open, int close, int max) {
        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max){
            backtrace(list,str+"(",open+1,close,max);
        }
        if(close < open){
            backtrace(list,str+")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        int n =3;
        List<String> list = generateParenthesis(n);
        System.out.println("result==" + list.toString());
    }
}
