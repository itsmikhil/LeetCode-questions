class Solution {
    // memoization
    // inspired from stock ii problem -> any number of buy and sell
    // ONLY CHANGE
    // AFTER EVERY SELL -> i+2
    int helper(int prices[], int dp[][], int i, int j) {
        // base case
        if (i >= prices.length)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        // we can buy stock
        if (j == 1) {
            // we are buying something so MINUS
            int buyNow = -prices[i] + helper(prices, dp, i + 1, 0);
            int wait = 0 + helper(prices, dp, i + 1, j);
            return dp[i][j] = Math.max(buyNow, wait);
        } else {
            // we are selling something so PLUS
            // COOL DOWN hai ilsiye i+2
            int sellNow = prices[i] + helper(prices, dp, i + 2, 1);
            int wait = 0 + helper(prices, dp, i + 1, j);
            return dp[i][j] = Math.max(sellNow, wait);
        }

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(prices, dp, 0, 1);
    }
}

class Solution {
    // tabulation same hai
    // Space Optimization (slight change)

    // tc: O(n*2)
    // sc: O(2*3)

    public int maxProfit(int[] prices) {

        int n = prices.length;

        // front1 -> dp[i+1] -> apna normal
        // front2 -> dp[i+2] -> cooldown mai i+2 ke zarurat padh sakti hai
        int front1[] = new int[2];
        int front2[] = new int[2];

        // Base Case
        // if(i >= prices.length)
        //     return 0;
        // front1 and front2 are already initialized with 0

        // ulta of memoization
        // i -> n-1 se 0

        for (int i = n - 1; i >= 0; i--) {

            int curr[] = new int[2];

            for (int j = 0; j < 2; j++) {

                if (j == 1) {

                    // Buy state

                    int buyNow = -prices[i] + front1[0];
                    int wait = front1[1];

                    curr[1] = Math.max(buyNow, wait);

                } else {

                    // Sell state

                    int sellNow = prices[i] + front2[1];
                    int wait = front1[0];

                    curr[0] = Math.max(sellNow, wait);
                }
            }

            // shift rows
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }
}