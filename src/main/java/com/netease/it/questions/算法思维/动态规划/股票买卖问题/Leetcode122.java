package com.netease.it.questions.算法思维.动态规划.股票买卖问题;

import java.util.Arrays;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by dujiayong on 2020/3/28.
 */
public class Leetcode122 {

    /**
     * 解法1:多次交易，可以拆分多个子问题，假设第一次交易完成，那么剩下的交易肯定是在第一次交易卖出时间以后发生
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return 0;
        }
        int currMin = prices[0];
        for (int sell = 1; sell < prices.length; sell++) {
            currMin = Math.min(prices[sell], currMin);
            res = Math.max(res, maxProfit(Arrays.copyOfRange(prices, sell + 1, prices.length)) + prices[sell] - currMin);
        }
        return res;
    }

    /**
     * 解法2:针对解法1的优化，解法1运行超出时间限制
     * 增加备忘录，消除重叠子问题计算
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int[] mem = new int[prices.length];
        Arrays.fill(mem, -1);
        return dp2(prices, 0, mem);
    }

    public static int dp2(int[] prices, int start, int[] mem) {
        if (start >= prices.length) {
            return 0;
        }
        if (mem[start] != -1) {
            return mem[start];
        }
        int res = 0;
        int currMin = prices[start];
        for (int sell = start + 1; sell < prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell]);
            res = Math.max(res, dp2(prices, sell + 1, mem) + prices[sell] - currMin);
        }
        mem[start] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
        int result = maxProfit2(prices);
        System.out.println("多次买卖一支股票的最大利润:" + result);
    }

}
