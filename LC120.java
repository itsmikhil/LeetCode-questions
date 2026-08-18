class Solution {
    // memoization
    // "TRY ALL POSSIBLE CASES"
    // UNDERSTAND THE BELOW DEFINITION -> i had confusion
    
    // Top-down = you write a recursive function for the original problem; it calls itself on subproblems; you cache results. Direction of data-dependency doesn't matter — it's top-down because you started at the top (original problem) and recursion drills down.
    
    // Bottom-up = no recursion at all. You fill a dp table using nested loops, starting from base cases, building up to the answer.
    // toh ye hai top down
    
    // TC:(n*n)
    // Sc:o(n)(stack space stores one path at a time) o(n^2)(dp matrix)
    int helper(List<List<Integer>> list,int dp[][],int i,int j){
        // integer max value because min find wala case
        if(j>=list.get(i).size()) return Integer.MAX_VALUE;

        // agar last row hai toh directly value hai
        if(i==list.get(list.size()-1).size()-1){
            return dp[i][j]=list.get(i).get(j);
        }

        // already calc 
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int below=list.get(i).get(j)+helper(list,dp,i+1,j);
        int diagonal=list.get(i).get(j)+helper(list,dp,i+1,j+1);

        return dp[i][j]=Math.min(below,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.get(triangle.size()-1).size();
        int dp[][]=new int[n][n];
        // integer max value because min find wala case
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return helper(triangle,dp,0,0);
    }
}
class Solution {
    // optimal
    // tabulation(bottom up)
    // steps to convert memoization to tabulation
    // -> write base case
    // ->compress all states in form of for loops
    // -> copy the recurrence and write
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // for 0th col we can only access top element
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                    // for i==j there is no top el
                } else if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                    // for other cases there is top element as well as top left diagonal
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }
        // note ans min hoga in last row in dp array
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[n - 1][j]);

        return ans;
    }
}
class Solution {
    // Space Optimization (2 Arrays)
    // In the 2D DP solution, dp[i][j] depends only on the previous row:
    // dp[i][j] = triangle[i][j] + min(dp[i-1][j], dp[i-1][j-1])
    //
    // Since no state depends on rows older than (i-1),
    // there is no need to store the entire DP table.
    //
    // So,
    // prev[] -> stores the previous row's DP values.
    // curr[] -> computes the current row's DP values.
    //
    // After finishing one row, make it the previous row for the next iteration.
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();

        int prev[] = new int[n];
        prev[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {

            int curr[] = new int[n];

            for (int j = 0; j <= i; j++) {

                // 0th column -> only top
                if (j == 0) {
                    curr[j] = triangle.get(i).get(j) + prev[j];
                }

                // last column -> only top-left diagonal
                else if (j == i) {
                    curr[j] = triangle.get(i).get(j) + prev[j - 1];
                }

                // middle cells
                else {
                    curr[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j - 1]);
                }
            }

            prev = curr;
        }

        // Answer is minimum in the last row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, prev[j]);
        }

        return ans;
    }
}