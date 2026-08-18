class Solution {
    //Mushkil nhi hai
    // memoization
    // top down
    // we have fixed start point(Robot1 starts at (0,0),Robot2 starts at (0,m-1)) and variable end point in this question
    // thats why we start with fixed start point
    // we need to track 4 vars -> i1,j1,i2,j2
    // but i toh common he hoga but dono haar baar pe same i pe jaa rahe hai
    // isliye i,j1,j2
    // isme hum dono robot ko ek saath chala rahe hai
    // agar dono robot same jagah par hai toh waha ki cherry sir ek baar count hogi -> IMP
    // Mushkil nhi hai
    // tc: (n*m*m*9) -> har box ke liye 9 aur task ho rahe hai 
    // sc: (n*m*m) + (n)(recursive stack)
    int helper(int[][] grid,int dp[][][],int i,int j1,int j2){
        // out of boundary
        if(i>=grid.length || i<0 || j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length){
            return Integer.MIN_VALUE;
        }
        // base case of last row
        if(i==grid.length-1){
            // robot same jagah hai toh sirf ek baar count hoga
            if(j1==j2){
                return grid[i][j1];
            }else{
                // robot alag jagah hai toh dono alag alag count hoga
                return grid[i][j1]+grid[i][j2];
            }
        }
        // already calc hai
        if(dp[i][j1][j2]!=Integer.MIN_VALUE) return dp[i][j1][j2]; 
        // 3 options hai dono robots ke pass 
        // toh 3*3 => 9 cases
        int dirs[]={-1,0,1};
        int max=Integer.MIN_VALUE;
        for(int m:dirs){
            for(int n:dirs){
                // robot same jagah hai toh sirf ek baar count hoga
                if(j1==j2){
                    max=Math.max(max,grid[i][j1]+helper(grid,dp,i+1,j1+m,j2+n));
                }else{
                     // robot alag jagah hai toh dono alag alag count hoga
                    max=Math.max(max,grid[i][j1]+grid[i][j2]+helper(grid,dp,i+1,j1+m,j2+n));
                }
            }
        }
        // assign and return 
        return dp[i][j1][j2]=max;

    }
    public int cherryPickup(int[][] grid) {
        // max cherry when ith row and robot 1 at j1 and robot 2 at j2
        int dp[][][]=new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        // Since every recursive call already gives the optimal future, taking the maximum over all 9 choices guarantees that the current state also stores the optimal total cherries. This is the principle of optimal substructure, which is why DP works here.
        return helper(grid,dp,0,0,grid[0].length-1);
    }
}
class Solution {
    // tabulation
    // first do memoization
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        // max cherry when ith row and robot 1 at j1 and robot 2 at j2
        // 3D DP table
        int[][][] dp = new int[n][m][m];

        // Base case: last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Fill DP table bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int) (-1e9);
                    int curr = (j1 == j2) ? grid[i][j1]
                            : grid[i][j1] + grid[i][j2];
                    // Try all 9 moves
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;
                            if (newJ1 >= 0 && newJ1 < m &&
                                    newJ2 >= 0 && newJ2 < m) {
                                maxi = Math.max(maxi, curr +
                                        dp[i + 1][newJ1][newJ2]);
                            } else {
                                maxi = Math.max(maxi, (int) (-1e9));
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }
}