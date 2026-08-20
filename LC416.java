class Solution {
    // similar to prev question 
    // isme hum pehle total sum nikal rahe hai array ka
    // agar woh odd hai matlab woh 2 equals parts mai divide ho he nhi sakta toh return false
    // agar woh even hai toh
    // hum prev question ka code use karke (sum/2) ke liye find kar rahe hai
    // because agar totalSum/2 ek subsequence ka sum hai toh for sure ek aur subsequence hoga 
    // jiska sum will be totalSum/2 -> our desired case

    // memoization
    // tc: (n*(totalSum/2))
    // sc: o(n*(totalSum/2) + n(recursive stack))
    boolean helper(int arr[],int dp[][],int i,int sum){
        // target achieved
        if(sum==0){
            return true;
        }
        
        // out of boundary
        if(i<0){
            return false;
        }
        
        // already calc
        if(dp[i][sum]!=-1) return dp[i][sum]==1?true:false;
        
        boolean notTake=helper(arr,dp,i-1,sum);
        
        // agar element mere req sum he bada hai toh mai kyu lu usse
        boolean take=false;
        if(arr[i]<=sum){
            take=helper(arr,dp,i-1,sum-arr[i]);
        }
        
        dp[i][sum]=take||notTake?1:0;
        return take||notTake;
    }

    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0){
            return false;
        }

        int dp[][]=new int[nums.length][(totalSum/2)+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,dp,nums.length-1,(totalSum)/2);
    }
}
class Solution {
    // similar to prev question 
    // isme hum pehle total sum nikal rahe hai array ka
    // agar woh odd hai matlab woh 2 equals parts mai divide ho he nhi sakta toh return false
    // agar woh even hai toh
    // hum prev question ka code use karke (sum/2) ke liye find kar rahe hai
    // because agar totalSum/2 ek subsequence ka sum hai toh for sure ek aur subsequence hoga 
    // jiska sum will be totalSum/2 -> our desired case

    // tabulation
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0){
            return false;
        }
        // here we can take bool array
        // in memoization we couldnt becauese there were 3 cases (-1,0,1)
        boolean dp[][]=new boolean[nums.length][(totalSum/2) + 1 ];

        // zero sum wali condition ko toh sab satisfy karenge
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }

        // agar targetSum=nums[0] toh woh obvio satisfy karega
        // hum dekh rahe hai ki nums[0]<=sum/2 because humare dp array ka size utna he hai
        // aur ye testCase imp hai kyuki iske baad hum row 0 ko touch nhi karte
        if(nums[0]<=(totalSum/2)){
            dp[0][nums[0]]=true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=notTake || take;
            }
        }

        return dp[nums.length-1][totalSum/2];
    }
}
class Solution {
    // similar to prev question 
    // isme hum pehle total sum nikal rahe hai array ka
    // agar woh odd hai matlab woh 2 equals parts mai divide ho he nhi sakta toh return false
    // agar woh even hai toh
    // hum prev question ka code use karke (sum/2) ke liye find kar rahe hai
    // because agar totalSum/2 ek subsequence ka sum hai toh for sure ek aur subsequence hoga 
    // jiska sum will be totalSum/2 -> our desired case

    // space optimization
    // we notice that our curr row only depends on prev row 
    // so why should be carry data of all rows
    // tc: (n*(totalSum)/2)
    // sc: (2n)
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        if(totalSum%2!=0){
            return false;
        }

        // initially this is the 0th row
        boolean prev[]=new boolean[(totalSum/2) +1];
        // this is the 0th col that we use to manually mark in tabulation code
        // IMP 
        prev[0]=true;
        // same base case as tabulation
        if(nums[0]<=(totalSum/2)){
            prev[nums[0]]=true;
        }

        for(int i=1;i<nums.length;i++){
            boolean curr[]=new boolean[(totalSum/2) +1];
            // this is the 0th col that we use to manually mark in tabulation code
            // IMP 
            curr[0]=true;
            for(int j=1;j<prev.length;j++){
                boolean notTake=prev[j];
                boolean take=false;
                if(nums[i]<=j){
                    take=prev[j-nums[i]];
                }
                curr[j]=notTake || take;
            }
            // curr becomes prev
            prev=curr;
        }

        return prev[totalSum/2];
    }
}