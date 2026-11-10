class Solution {
    // Memoization
    // o(n)
    int helper(int costs[],int dp[],int curr){
        if(curr==costs.length){
            return 0;
        }
        if(dp[curr]!=-1){
            return dp[curr];
        }
        int min=Integer.MAX_VALUE;
        for(int i=curr+1;i<=curr+3 && i<=costs.length;i++){
            int jump=i-curr;
            int currCost=costs[i-1] + (jump*jump) +helper(costs,dp,i);
            min=Math.min(min,currCost);
        }
        return dp[curr]=min;
    }
    public int climbStairs(int n, int[] costs) {
        // dp[i] represents the minimum cost required to reach the top starting from position i
        int dp[]=new int[costs.length+1];
        Arrays.fill(dp,-1);
        return helper(costs,dp,0);
    }
}
class Solution {
    // Tabulation
    // o(n)
    
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[costs.length+1];
        dp[n]=0;
        for(int curr=n-1;curr>=0;curr--){
            int min=Integer.MAX_VALUE;
            for(int j=curr+1;j<=n && j<=curr+3;j++){
                int jump=j-curr;
                int currCost=costs[j-1] + (jump*jump) +dp[j];
                min=Math.min(min,currCost);
            }
            dp[curr]=min;
        }
        return dp[0];
    }
}