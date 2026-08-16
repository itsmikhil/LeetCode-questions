class Solution {

    // intuition : "TRY ALL POSSIBLE CASES"
    // brute mai dp array hata do neeche wale code se
    // tc:2^n

    // better
    // memoization
    // top down
    // tc: o(n)
    // sc: o(n)(rec stack)+o(n)(dp array)
    int helper(int nums[],int idx,int dp[]){
        // idx of zero pe toh sirf ek he option hai
        if(idx==0) return nums[0];
        // matlab array ke bahar nikla gaye hai kuch hai nhi pick ya notpick ke liye
        if(idx<0) return 0;
        // agar already calc kar liye hai toh wahi return kardo
        if(dp[idx]!=-1) return dp[idx];
        // agar mai ne curr wala pick kiya hia toh mai adjacent wale ko dekhunga bhi nhi
        int pick=nums[idx]+helper(nums,idx-2,dp);
        // agar mai curr wala nhi le raha hu toh adj wala dekhta hu
        int notpick=helper(nums,idx-1,dp);
        // isme se jo bhi max aayega usse assign kar dunga arrat mai
        return dp[idx]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
}

class Solution {
    public int rob(int[] nums) {
        // optimal
        // bottom up
        // tc: o(n)
        // sc:o(n) -> dp array
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp[]=new int[nums.length];

        // base case
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        
        for(int i=2;i<nums.length;i++){
            int take=dp[i-2]+nums[i];
            int nottake=dp[i-1];
            dp[i]=Math.max(take,nottake);
        }

        return dp[nums.length-1];
    }
}

class Solution {
    public int rob(int[] nums) {
        // optimal(Space optimized)
        // bottom up
        // tc: o(n)
        // sc:o(1) -> dp array

        // we need only prev 2 states to decide curr state 
        // then pura array leke kyu chale ??
        // lets optimize
        
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }


        // base case
        int prev2=nums[0];
        int prev1=Math.max(prev2,nums[1]);
        int curr=-1;
        
        for(int i=2;i<nums.length;i++){
            int take=prev2+nums[i];
            int nottake=prev1;
            curr=Math.max(take,nottake);
            prev2=prev1;
            prev1=curr;
        }

        return curr;
    }
}