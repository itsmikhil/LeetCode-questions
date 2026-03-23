class Solution {
    int minCost(int[] height) {
        int dp[]=new int[height.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<height.length-1;i++){
            dp[i+1]=Math.min(dp[i+1],dp[i]+Math.abs(height[i+1]-height[i]));
            if(i+2<height.length){
                dp[i+2]=Math.min(dp[i+2],dp[i]+Math.abs(height[i+2]-height[i]));
            }
        }
        return dp[height.length-1];
    }
}