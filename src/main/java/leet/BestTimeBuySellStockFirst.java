package leet;
//121
public class BestTimeBuySellStockFirst {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
//    public static int maxProfit(int[] prices) {
//
//        int maxProfit = 0;
//
//        for( int buy = 0;buy<prices.length;buy++){
//            for(int sell = buy+1;sell<prices.length;sell++) {
//                int profit = prices[sell] - prices[buy];
//                maxProfit = Math.max(profit,maxProfit);
//            }
//        }
//        return maxProfit;
//    }
public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    int minValue = Integer.MAX_VALUE;

    for(int i=0;i<prices.length;i++) {
        if(prices[i] < minValue)
            minValue = prices[i];
        else {
            int profit = prices[i] - minValue;
            maxProfit = Math.max(profit,maxProfit);
        }
    }
    return maxProfit;
    }

}
