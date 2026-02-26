package leet.arrayorstring;
//121
public class BestTimeBuySellStockSecond {
    public static void main(String[] args) {
        BestTimeBuySellStockSecond btbss = new BestTimeBuySellStockSecond();
        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7,6,4,3,1};
        System.out.println(btbss.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i=1;i< prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }

}
