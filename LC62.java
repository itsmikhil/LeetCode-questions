class Solution {
    // simple nhi hai kya ??
    // better -> memoization
    // top down -> goal se start point
    // agar hum 0,0 reach kar jaaye toh return 1 -> imp for counting number of paths
    // Tc: m*n
    // sc:O(m+n)(stack stores only the current path being followed) + (m*n)(dp) 
    int helper(int dp[][],int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0 ) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=helper(dp,i,j-1);
        int up=helper(dp,i-1,j);
        return dp[i][j]=left+up;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,m-1,n-1);
    }
}
class Solution {
    // optimal
    // bottom up
    // steps to convert memoization to tabulation
    // -> write base case
    // ->compress all states in form of for loops
    // -> copy the recurrence and write
    public int uniquePaths(int m, int n) {
        // iska matlab hai iss box se 0,0 pohochne ke kitne raaste hai
        // toh any cell with 0th row or 0th col mai sirf ek he tareeka hai 0,0 pohochne ka 
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        // baaki same code chaapa hai memoization se
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }   
        return dp[m-1][n-1];
    }
}