package com.netease.it.questions.nowcoder.offer.question2;

/**
 * Created by dujiayong on 2020/2/5.
 */
public class Solution {

    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We are happy");
        String result = replaceSpace(buffer);
        System.out.println("result=" + result);
    }


}
