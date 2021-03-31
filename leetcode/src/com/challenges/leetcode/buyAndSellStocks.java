/*
 * question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

package com.challenges.leetcode;

public class buyAndSellStocks {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int currMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currMin) {
                currMin = prices[i];
            }
            else {
                if (maxProfit < (prices[i] - currMin)) {
                    maxProfit = (prices[i] - currMin);
                }
            }
        }

        return maxProfit;

    }
}
