package com.netease.it.questions.leetcode.question43;

/**
 * Created by dujiayong on 2020/2/5.
 */
public class Solution2 {

    public static String multiply(String num1,String num2){
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        int[] res = new int[num1.length()+num2.length()];
        for(int i=num2.length()-1;i>=0;i--){
            int n2 = num2.charAt(i) - '0';
            for(int j=num1.length()-1;j>=0;j--){
                int n1 = num1.charAt(j) - '0';
                int sum = n1*n2+res[i+j+1];
                res[i+j+1] = sum%10;
                res[i+j] += sum/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0&&res[i] ==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "9", num2 = "9";
        String result = multiply(num1, num2);
        System.out.println("result=" + result);
    }

}
