class Solution {
    // memoization
    
    // we needed somethinig to tell us if we already own a stock or not
    // thats why j comes into the picture
    // i->days
    // j=1-> we can buy stock
    // j=0-> we own a stock so we can sell 
    // initiallly start with 0,1 means we can but stock

    // tc: (n*2)
    // sc:(n*2) plus recursive stack space
    int helper(int prices[],int dp[][],int i,int j){
        // base case
        if(i>=prices.length) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        // we can buy stock
        if(j==1){
            // option1 : buyNow matlab aaj he new stock khareedo
            // kal se stock beech sakte hai

            // we can buying something so MINUS
            int buyNow= -prices[i]+helper(prices,dp,i+1,0);

            // option2 : wait karo aage lenge
            // j remains same 
            int wait= 0+helper(prices,dp,i+1,j);

            // return max
            return dp[i][j]=Math.max(buyNow,wait);
        }else{
            // we have the stock we can sell
            // option1 : sellNow and we will get right to buy new stock from next day
            // we are selling something so PLUS
            int sellNow= prices[i]+helper(prices,dp,i+1,1);

            // option2 : wait karte hai baad mai bechenge
            // we still stock so j stays same
            int wait=0+helper(prices,dp,i+1,j);

            // return max
            return dp[i][j]=Math.max(sellNow,wait);
        }

    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];

        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(prices,dp,0,1);
    }
}

class Solution {
    // tabulation

    // tc: (n*2)
    // sc:(n*2) 
    public int maxProfit(int[] prices) {
        // yaha pe n+1 ka array banyenge because base case bhi store karna hai
        int n=prices.length;
        int dp[][]=new int[n+1][2];

        // memoization wala base case
        dp[n][0]=dp[n][1]=0;

        // yaha pe i -> n-1 se zero -> opposoite of memoization
        for(int i=n-1;i>=0 ;i--){
            for(int j=0;j<=1;j++){
                if(j==1){
                    int buyNow= -prices[i]+dp[i+1][0];
                    int wait= 0+dp[i+1][j];
                    dp[i][j]=Math.max(buyNow,wait);
                }else{
                    int sellNow= prices[i]+dp[i+1][1];
                    int wait=0+dp[i+1][j];
                    dp[i][j]=Math.max(sellNow,wait);
                }
            }
        }

        return dp[0][1];
    }
}
class Solution {
    // Space optimization
    // our curr state only depends on prev state

    // tc: (n*2)
    // sc:(2*2) 
    public int maxProfit(int[] prices) {
        int n=prices.length;

        // we can also use 2 variables instead of 2 sized array
        int prev[]=new int[2];

        // memoization wala base case
        prev[0]=prev[1]=0;

        // yaha pe i -> n-1 se zero -> opposoite of memoization
        for(int i=n-1;i>=0 ;i--){
            int curr[]=new int[2];
            for(int j=0;j<=1;j++){
                if(j==1){
                    int buyNow= -prices[i]+prev[0];
                    int wait= 0+prev[j];
                    curr[j]=Math.max(buyNow,wait);
                }else{
                    int sellNow= prices[i]+prev[1];
                    int wait=0+prev[j];
                    curr[j]=Math.max(sellNow,wait);
                }
            }
            prev=curr;
        }

        return prev[1];
    }
}