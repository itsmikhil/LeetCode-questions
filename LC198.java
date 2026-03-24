// brute force
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[]=new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=nums[0];
        dp[1]=nums[1];
        // int max=Integer.MIN_VALUE;
        // i had to include below Math.max and remove aboce one becuase otherwise for cases like [1,3,1] for idx=1  inner loop doesnt run
        int max=Math.max(dp[0],dp[1]);
        for(int i=0;i<nums.length;i++){
            for(int j=i+2;j<nums.length;j++){
                dp[j]=Math.max(dp[j],dp[i]+nums[j]); 
                max=Math.max(max,dp[j]);
            }
        }
        return max;
    }
}

