class Solution {
    // Memoization
    // "Try all possible paths and store the minimum one"
    int helper(int grid[][],int dp[][],int i,int j,int sum){
        if(i==0 && j==0) return dp[i][j]=grid[i][j];
        // mai yaha pe bhi zero return kar raha tha
        // because of which ye hamesh sabse chota ho ja raha tha left and up comparisons mai
        // IMP
        if(i<0 || j<0) return Integer.MAX_VALUE;
        // already calculated
        if(dp[i][j]!=-1) return dp[i][j];

        // left lene se kya min sum mil raha hai
        int left=helper(grid,dp,i,j-1,sum+grid[i][j]);
        // up lene se kya min sum mil raha hai
        int up=helper(grid,dp,i-1,j,sum+grid[i][j]);


        return dp[i][j]=grid[i][j]+Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(grid,dp,grid.length-1,grid[0].length-1,grid[grid.length-1][grid[0].length-1]);
    }
}
class Solution {
    // Tabulation
    // Bottom Up
    // TC: O(m*n)
    // SC: O(m*n)
    // converted memoization to tabulation

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        // Base case
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Base case already filled
                if (i == 0 && j == 0)
                    continue;

                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;

                if (i > 0)
                    up = dp[i - 1][j];

                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}