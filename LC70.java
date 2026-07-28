class Solution {
    // dp brute force
    // memoization(top down approach)
    // tc: o(n)
    // sc: o(n) -> storage array with stack space

    int fibonacci(int n,int dp[]){
        if(n==0 || n==1) return 1;
        if(dp[n]!=0) return dp[n];
        dp[n]=fibonacci(n-2,dp)+fibonacci(n-1,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        return fibonacci(n,dp);
    }
}

class Solution {
    // dp better
    // tabulation(down top approach)
    // tc: o(n)
    // sc: o(n) -> storage array + looping iteration

    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

class Solution {
    // dp optimal (removeed storage space)
    // tabulation(down top approach)
    // tc: o(n)
    // sc: o(n) -> iteration

    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        int prev1=1;
        int prev2=1;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
        }
        return ans;
    }
}
