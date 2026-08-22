class Solution {
    // Memoization
    // ZEROS not included in array
    // following our mantra
    // "Infinite supply mai bhi ek ek karke lo"
    
    // not moving ith pointer in take case
    // only moving it in case of notTake
    
    // Time: O(n * capacity)
    // Space: O(n * capacity) + O(capacity) recursion stack
    static int helper(int val[],int wt[],int dp[][],int i,int cap){
        if(cap==0){
            return 0;
        }
        
        if(i<0){
            return 0;
        }
        
        if(dp[i][cap]!=-1) return dp[i][cap];
        
        int notTake=helper(val,wt,dp,i-1,cap);
        
        int take=Integer.MIN_VALUE;
        if(wt[i]<=cap){
            take=val[i]+helper(val,wt,dp,i,cap-wt[i]);
        }
        
        return dp[i][cap]=Math.max(take,notTake);
    }
    public int knapSack(int val[], int wt[], int capacity) {
       int dp[][]=new int[val.length][capacity+1];
       
       for(int i=0;i<dp.length;i++){
           Arrays.fill(dp[i],-1);
       }
       
       return helper(val,wt,dp,val.length-1,capacity);
    }
}
class Solution {
    // Tabulation
    // ZEROS not included in array
    // following our mantra
    // "Infinite supply mai bhi ek ek karke lo"
    
    // not moving ith pointer in take case
    // only moving it in case of notTake
    
    // Time: O(n * capacity)
    // Space: O(n * capacity)
    
    public int knapSack(int val[], int wt[], int capacity) {
       int dp[][]=new int[val.length][capacity+1];
    
        // NOTE BASES CASES
        
       // capacity = 0
       for(int i=0;i<dp.length;i++){
           dp[i][0] = 0;
       }

       // only first item available
       for(int cap=0; cap<=capacity; cap++){
           if(wt[0] <= cap){
               dp[0][cap] = (cap / wt[0]) * val[0];
           }
       }
       
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               
               int notTake=dp[i-1][j];
               
               int take=Integer.MIN_VALUE;
               if(wt[i]<=j){
                   take=val[i]+dp[i][j-wt[i]];
               }
               
               dp[i][j]=Math.max(take,notTake);
           }
       }
       
       return dp[val.length-1][capacity];
    }
}
class Solution {

    // Space Optimized Tabulation using prev and curr
    // Infinite supply:
    // TAKE -> same row
    // NOT TAKE -> previous row

    // Time: O(n * capacity)
    // Space: O(capacity)

    public int knapSack(int val[], int wt[], int capacity) {

        int prev[] = new int[capacity + 1];

        // Base case:
        // only first item available
        for(int cap = 0; cap <= capacity; cap++){

            if(wt[0] <= cap){
                prev[cap] = (cap / wt[0]) * val[0];
            }
        }


        for(int i = 1; i < val.length; i++){

            int curr[] = new int[capacity + 1];

            for(int j = 1; j <= capacity; j++){

                int notTake = prev[j];

                int take = Integer.MIN_VALUE;

                if(wt[i] <= j){

                    // same row because infinite supply
                    take = val[i] + curr[j - wt[i]];
                }

                curr[j] = Math.max(take, notTake);
            }

            prev = curr;
        }


        return prev[capacity];
    }
}
class Solution {

    // Space Optimized Tabulation using prev and curr
    // Infinite supply:
    // TAKE -> same row
    // NOT TAKE -> previous row
    
    // Why single array works?
    //
    // In 2D DP:
    // dp[i][j] stores answer using items 0 to i with capacity j.
    //
    // For every state:
    // notTake = dp[i-1][j]          -> previous row
    // take    = val[i] + dp[i][j-wt[i]] -> same row
    //
    // We only need capacity values, not all rows.
    //
    // In 1D:
    // - dp[j] stores the previous row's answer before updating.
    //   So it works as notTake.
    //
    // - For take, we need dp[j-wt[i]] from the same row.
    //   Because we move j from left to right, dp[j-wt[i]]
    //   is already updated for the current item.
    //
    // Hence one array is enough.

    // Time: O(n * capacity)
    // Space: O(capacity)

   public int knapSack(int val[], int wt[], int capacity) {

   int dp[] = new int[capacity + 1];

   // Only first item available
   // Item can be picked multiple times
   for(int cap = 0; cap <= capacity; cap++){

       if(wt[0] <= cap){
           dp[cap] = (cap / wt[0]) * val[0];
       }
   }


   for(int i = 1; i < val.length; i++){

       for(int j = 1; j <= capacity; j++){

           int notTake = dp[j];

           int take = Integer.MIN_VALUE;

           if(wt[i] <= j){
               take = val[i] + dp[j - wt[i]];
           }

           dp[j] = Math.max(take, notTake);
       }
   }

   return dp[capacity];
    }
}