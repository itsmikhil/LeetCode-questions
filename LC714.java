class Solution {
    // inspired by stock ii
    // bass har sell ke baad MINUS FEE bhi kardo
    // because transaction complete hui hai
    int helper(int prices[],int fee,int dp[][],int i,int j){
        // base case
        if(i>=prices.length) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        // we can buy stock
        if(j==1){
            // we can buying something so MINUS
            int buyNow= -prices[i]+helper(prices,fee,dp,i+1,0);
            int wait= 0+helper(prices,fee,dp,i+1,j);
            return dp[i][j]=Math.max(buyNow,wait);
        }else{
            // we are selling something so PLUS
            int sellNow= prices[i] - fee +helper(prices,fee,dp,i+1,1);
            int wait=0+helper(prices,fee,dp,i+1,j);
            return dp[i][j]=Math.max(sellNow,wait);
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int dp[][]=new int[prices.length][2];

        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(prices,fee,dp,0,1);
    }
}