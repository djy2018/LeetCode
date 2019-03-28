package com.netease.it.questions.question11;

/**
 * @author dujiayong
 * @date 2019/03/22
 **/
public class Solution2 {

    public static int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }

        int maxArea = 0;

        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                int curHeight = height[i];
                int preHeight = height[j];
                int curArea = curHeight > preHeight ? preHeight * (i - j) : curHeight * (i - j);
                if (curArea > maxArea) {
                    maxArea = curArea;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("maxArea=" + maxArea);

    }
}
