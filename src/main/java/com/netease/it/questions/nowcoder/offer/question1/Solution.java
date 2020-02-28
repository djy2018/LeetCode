package com.netease.it.questions.nowcoder.offer.question1;

/**
 * Created by dujiayong on 2020/2/5.
 */
public class Solution {

    public static boolean find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find2(int target, int[][] array) {
        // 左下角(同行最小 同列最大)初始
        int rows = array.length;
        if(rows == 0){
            return false;
        }

        int cols = array[0].length;
        if(cols == 0){
            return false;
        }

        int row = rows-1;
        int col = 0;
        while (row>=0&&col<cols){
            if(array[row][col] > target){
                row--;
            }else if(array[row][col] < target){
                col++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 5, 7}, {2, 4, 6, 8}};
        int target = 5;
        boolean result = find2(target, array);
        System.out.println("result=" + result);
    }


}
