class Solution {
    // memoization 
    // "Try all possible ways" -> Always the mantra
    // same as prev question just one line added 
    // if(mat[i][j]==1) return dp[i][j]=0;

    int helper(int mat[][],int dp[][],int i,int j){
        // invalid idx
        if(i<0 || j<0) return 0;
        // obstacle hai , remember to set it zero in dp matrix
        if(mat[i][j]==1) return dp[i][j]=0;
        // reached destination
        if(i==0 && j==0) return dp[i][j]=1;
        // already calculated state
        if(dp[i][j]!=-1) return dp[i][j];

        int left=helper(mat,dp,i,j-1);
        int up=helper(mat,dp,i-1,j);

        return dp[i][j]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacleGrid,dp,obstacleGrid.length-1,obstacleGrid[0].length-1);
    }
}
class Solution {
    // optimal
    // tabulation
    // steps to convert memoization to tabulation
    // -> write base case
    // ->compress all states in form of for loops
    // -> copy the recurrence and write
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // i,j ka matlab hai hai yaha se 0,0 jaane ke kitne tareeke using only given directions
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];

        // beech mai obstacle aagya matalb yaha se 0,0 jaa he nhi sakte 
        // checkinh for 0th col
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            } else {
                dp[i][0] = 1;
            }
        }
        // beech mai obstacle aagya matalb yaha se 0,0 jaa he nhi sakte 
        // checkinh for 0th row
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        // apna normal code
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        // return condi
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}