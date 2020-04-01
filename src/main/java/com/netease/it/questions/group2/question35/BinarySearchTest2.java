package com.netease.it.questions.group2.question35;

/**
 * @author dujiayong
 * @date 2019/08/26
 **/
public class BinarySearchTest2 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long left = 0;
        long right = x/2 + 1;
        while (left < right) {
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        int i = mySqrt(2147395599);
        System.out.println("result=" + i);
    }

}
