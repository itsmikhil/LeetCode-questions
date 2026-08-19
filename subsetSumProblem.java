class Solution {
    // top down -> wait for other states to finish
    // writing code this makes it easier to convert into tabulation
    // in dp array:
    // i-> num of elements from 0 to i which are available
    // j-> sum we want to form
    // tc: n*targetSum
    // sc: n*targetSum + n(recursive stack)
    static boolean helper(int arr[],int dp[][],int i,int sum){
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
    static boolean isSubsetSum(int arr[], int sum) {
        // i-> num of elements from 0 to i which are available
        // j-> sum we want to form
        int dp[][]=new int[arr.length][sum+1];
        for(int i=0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,dp,arr.length-1,sum);
    }
}
class Solution {
    
    static boolean isSubsetSum(int arr[], int sum) {
        // i-> num of elements from 0 to i which are available
        // j-> sum we want to form
        // NOTE: yaha pe boolean array le sakte hai
        // because prev code(memoization) mai 3 states thi -1,0,1
        
        // DRY RUN DEKHLO JENNY KA IF NEEDED
        
        boolean dp[][]=new boolean[arr.length][sum+1];
        
        for(int i=0;i<arr.length;i++){
            dp[i][0]=true;
        }
        
        // sirf zeroth el ho aur targetSum bhi uske barabar ho toh bana obvio bana sakte hai
        // ye zaruri hai because iske baad hum 0th row kabhi mai kabhi computation nhi kar rahe hai
        if(arr[0] <= sum)
            dp[0][arr[0]] = true;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(arr[i]<=j){
                    take=dp[i-1][j-arr[i]];
                }
                dp[i][j]=take||notTake;
            }
        }
        
        return dp[arr.length-1][sum];
    }
}