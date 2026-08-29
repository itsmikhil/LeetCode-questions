class Solution {
    // same as prev question
    // here instead of 2 trans we need to perform atmost k trans

    // memoization

    // yaha pe woh "another method" wala solution try kiya hai
    // we could also use 3d array like prev question

    // here 2*k+1 
    // if k is odd -> free to buyNew stock
    // if k is even -> free to sell the stock

    int helper(int prices[],int dp[][],int i,int transNo){

        // array ke bahar chale gaye
        if(i>=prices.length){
            return 0;
        }

        // transNo >= 2*k+1 then we have exhausted all buy sell count
        if(transNo >= dp[0].length){
            return 0;
        }

        // already calc
        if(dp[i][transNo]!=-1) return dp[i][transNo];

        if(transNo%2==1){
            // yaha pe we incremennt transNo for every buy or sell because 2*k+1 len ka array hai
            // pehle wale mai sirf k len ka tha where k was no of complete trans(buy and sell)

            // NOTE THE MINUS
            int buyNow= -prices[i] + helper(prices,dp,i+1,transNo+1);
            int wait= 0 + helper(prices,dp,i+1,transNo);
            return dp[i][transNo]=Math.max(buyNow,wait);
        }else{
            int sellNow=prices[i]+helper(prices,dp,i+1,transNo+1);
            int wait= 0+helper(prices,dp,i+1,transNo);
            return dp[i][transNo]=Math.max(sellNow,wait);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        // NOTE 2*k+1
        int dp[][]=new int[n][2*k+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(prices,dp,0,1);
    }
}

class Solution {

    // Tabulation
    // dp[i][transNo] = maximum profit starting from day i
    // when we are at transaction number transNo

    // tc: O(n * 2k)
    // sc: O(n * 2k)

    public int maxProfit(int k, int[] prices) {

        // if k == 0, answer is 0
        if (k == 0)
            return 0;

        int n = prices.length;

        // n+1 rows -> one extra dor storing base case -> NOTE
        // 2*k+2 columns -> one extra dor storing base case -> NOTE
        int dp[][] = new int[n + 1][2 * k + 2];

        // Base Cases

        // i >= n
        // no days left, profit = 0
        for (int transNo = 1; transNo <= 2 * k; transNo++) {
            dp[n][transNo] = 0;
        }

        // transNo >= 2*k+1

        for (int i = 0; i <dp.length; i++) {
            dp[i][2*k+1] = 0;
        }

        // ulta of memoization
        // i-> n-1 se zero

        for (int i = n - 1; i >= 0; i--) {

            for (int transNo = 1; transNo <= 2*k; transNo++) {

                if (transNo % 2 == 1) {

                    // Buy state

                    int buyNow = -prices[i] + dp[i + 1][transNo + 1];

                    int wait = dp[i + 1][transNo];

                    dp[i][transNo] = Math.max(buyNow, wait);

                } else {

                    // Sell state

                    int sellNow = prices[i]+ dp[i + 1][transNo + 1];

                    int wait = dp[i + 1][transNo];

                    dp[i][transNo] = Math.max(sellNow, wait);
                }
            }
        }

        

        return dp[0][1];
    }
}
class Solution {

    // Space Optimization
    // tc: O(n * 2*k)
    // sc: O(2*k)

    public int maxProfit(int k, int[] prices) {

        // if k == 0, answer is 0
        if (k == 0)
            return 0;

        int n = prices.length;

        // stores dp[i+1]
        int next[] = new int[2 * k + 2];

        // Base Case
        // if(i >= n) return 0;
        // next[] is already initialized with 0

        for (int i = n - 1; i >= 0; i--) {

            // stores dp[i]
            int curr[] = new int[2 * k + 2];

            // if(transNo >= 2*k+1) return 0;
            curr[2 * k + 1] = 0;

            for (int transNo = 1; transNo <= 2 * k; transNo++) {

                if (transNo % 2 == 1) {

                    // Buy state

                    int buyNow = -prices[i] + next[transNo + 1];
                    int wait = next[transNo];

                    curr[transNo] = Math.max(buyNow, wait);

                } else {

                    // Sell state

                    int sellNow = prices[i] + next[transNo + 1];
                    int wait = next[transNo];

                    curr[transNo] = Math.max(sellNow, wait);
                }
            }

            next = curr;
        }

        return next[1];
    }
}