package com.netease.it.questions.算法思维.动态规划.股票买卖问题;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * Created by dujiayong on 2020/3/28.
 */
public class Leetcode121 {

    /**
     * 解法1:固定买入时间点，然后动态移动卖出时间点，卖出总是大于买入，最终获取买入1次可获得的最大利润
     * 贪心算法：每次都尽力获取最大利润
     * -> 动态规划的一个特殊写法
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int buy = 0; buy < prices.length - 1; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                res = Math.max(res, prices[sell] - prices[buy]);
            }
        }
        return res;
    }

    /**
     * 解法2:固定卖出时间点，然后保证买入时间时价格最低，最后获取买入1次的最大利润
     * 对第一种解法的优化，减少一个for循环
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int res = 0;
        // 卖出时间固定，保证买入时间时价格最少
        int currMin = Integer.MAX_VALUE;
        for (int sell = 1; sell < prices.length; sell++) {
            currMin = Math.min(currMin, prices[sell - 1]);
            res = Math.max(res, prices[sell] - currMin);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        int result = maxProfit2(prices);
        System.out.println("股票买卖最大利润：" + result);
    }

}
