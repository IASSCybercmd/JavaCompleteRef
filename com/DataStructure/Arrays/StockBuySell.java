package com.DataStructure.Arrays;


/**
 * PROBLEM STATEMENT:
 * 
 * You are given an array of prices where prices[i] is the price of a given stock on an ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock. Return the maximum profit you can achieve 
 * from this transaction. If you cannot achieve any profit, return 0.
 * 
 * @author PRIYANSHU RAJ
 * @category Medium lvl
 * 
 */
public class StockBuySell{


    public static int maxStockBenefit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            //checking for min value
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }

            //checking for max Profit
            if(prices[i]-minPrice > maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {2,7,1,5,3,6,4};
        System.out.println("The maxium profit is " + maxStockBenefit(prices));
    }

}