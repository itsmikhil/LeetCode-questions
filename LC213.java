class Solution {
    // In a circular street, first and last houses are adjacent,
    // so they cannot both be robbed.
    //
    // Break the circle into two independent linear cases:
    // 1. Exclude the last house  -> rob houses [0 ... n-2]
    // 2. Exclude the first house -> rob houses [1 ... n-1]
    //
    // Reuse the House Robber I logic for both cases
    // and return the maximum of the two answers.

    int helper(int nums[],int start,int n){
        int prev2=nums[start];
        int prev1=Math.max(prev2,nums[start+1]);
        int curr=-1;
        
        for(int i=start+2;i<n;i++){
            int take=prev2+nums[i];
            int nottake=prev1;
            curr=Math.max(take,nottake);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        
        return Math.max(helper(nums,0,nums.length-1),helper(nums,1,nums.length));
    }
}