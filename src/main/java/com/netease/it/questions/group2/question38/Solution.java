package com.netease.it.questions.group2.question38;

/**
 * @author dujiayong
 * @date 2019/08/27
 **/
public class Solution {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String preStr = "1";
        String nexStr = "";
        String num = "";
        int count = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < preStr.length(); j++) {
                String numStr = preStr.substring(j, j + 1);
                if (!num.equals(numStr)) {
                    if (!num.equals("")) {
                        nexStr = nexStr + count + num;
                        count = 0;
                    }
                    num = numStr;
                    count++;
                } else {
                    count++;
                }
            }
            nexStr = nexStr + count + num;
            preStr = nexStr;
            nexStr = "";
            num = "";
            count = 0;
        }

        return preStr;
    }

    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println("result=" + s);
    }


}
