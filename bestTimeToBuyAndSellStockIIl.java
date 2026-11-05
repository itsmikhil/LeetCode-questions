import java.util.*;
public class Solution {
    static int helper(int[] prices,int dp[][][],int idx,int numOfTrans,int buyOrSell){
        if(numOfTrans==0 ){
            return 0;
        }
        if(idx==prices.length){
            if(buyOrSell==1) return (int)-1e9;
            return 0;
        }
        if(dp[idx][numOfTrans][buyOrSell]!=-1){
            return dp[idx][numOfTrans][buyOrSell];
        }
        if(buyOrSell==0){
            int buyNow= -prices[idx] + helper(prices,dp,idx+1,numOfTrans,1);
            int buyWait= helper(prices,dp,idx+1,numOfTrans,0);
            return dp[idx][numOfTrans][buyOrSell]=Math.max(buyNow,buyWait);
        }
        if(buyOrSell==1){
            int sellNow= prices[idx]+helper(prices,dp,idx+1,numOfTrans-1,0);
            int sellWait=helper(prices,dp,idx+1,numOfTrans,1);
            return dp[idx][numOfTrans][buyOrSell]=Math.max(sellNow,sellWait);
        }
        return 0;
    }
    public static int maxProfit(int[] prices) {
        int dp[][][]=new int[prices.length][3][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(prices,dp,0,2,0);
    }
}