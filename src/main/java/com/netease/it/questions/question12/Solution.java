package com.netease.it.questions.question12;

import java.util.Map;
import java.util.TreeMap;

/**
 * 解决类
 * @author dujiayong
 * @date 2019/03/27
 **/
public class Solution {

    public static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1,"I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] chars = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        while (num != 0){
            for (int i = 0; i < nums.length; i++) {
                if(num >= nums[i]){
                    builder.append(chars[i]);
                    num -= nums[i];
                    break;
                }
            }
        }
        return builder.toString();
    }

    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static String intToRoman3(int num){
        StringBuilder builder = new StringBuilder();
        while (num != 0){
            // floorEntry方法取最接近于Key的值
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            builder.append(entry.getValue());
            num -= entry.getKey();
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String result = intToRoman3(1994);
        System.out.println("result=" + result);
    }


}
