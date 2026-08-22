class Solution {
    // NOTE
    // yaha array mai zero bhi ho sakta hai 
    // toh wahi wala code likhenge

    // memoization
    
    // brute force approach
    // "TRY ALL POSSIBLE CASES"
    // wahi take and notTake ke badle + and minus assign karenge kar element ko
    // but waha sum minus bhi ho skata hai
    // toh use dp array mai kaise store karoge
    // solution store karte time [sum+totalSum] isse sab kaise  hondle ho jaayega
    // but length of dp ko [nums.length][2*totalSUm+1] rakhna

    // BetterApproach -> our curr one
    // har el ko + ya - minus kar sakte hai
    // yaad karo ye toh wahi ban gaya agar sab plus wale s1 hai
    // aur sab minus wale s2 hai toh s1-s2=diff
    // yaha diff matalb target
    // wahi question ka tareeka apply hoga as it is

    int helper(int nums[],int dp[][],int i,int sum){
        if(i==0){
            if(nums[0]==0 && sum==0) return 2;
            else if(nums[0]==sum || sum==0) return 1;
            else return 0;
        }
        int notTake=helper(nums,dp,i-1,sum);
        int take=0;
        if(nums[i]<=sum){
            take=helper(nums,dp,i-1,sum-nums[i]);
        }
        return dp[i][sum]=notTake+take;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        int numerator=totalSum-target;
        if(numerator%2!=0) return 0;
        if(numerator<0) return 0;

        int newTarget=numerator/2;

        int dp[][]=new int[nums.length][newTarget+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums,dp,nums.length-1,newTarget);
    }
}
class Solution {
    // NOTE
    // yaha array mai zero bhi ho sakta hai 
    // toh wahi wala code likhenge

    // Tabulation
    
    // brute force approach
    // "TRY ALL POSSIBLE CASES"
    // wahi take and notTake ke badle + and minus assign karenge kar element ko
    // but waha sum minus bhi ho skata hai
    // toh use dp array mai kaise store karoge
    // solution store karte time [sum+totalSum] isse sab kaise  hondle ho jaayega
    // but length of dp ko [nums.length][2*totalSUm+1] rakhna

    // BetterApproach -> our curr one
    // har el ko + ya - minus kar sakte hai
    // yaad karo ye toh wahi ban gaya agar sab plus wale s1 hai
    // aur sab minus wale s2 hai toh s1-s2=diff
    // yaha diff matalb target
    // wahi question ka tareeka apply hoga as it is

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        int numerator=totalSum-target;
        if(numerator%2!=0) return 0;
        if(numerator<0) return 0;

        int newTarget=numerator/2;

        int dp[][]=new int[nums.length][newTarget+1];

        dp[0][0]=1;

        if(nums[0]==0){
            dp[0][0]=2; //{} {0}
        }

        // nums!=0 because uss case mai toh hume 2 place karna hai na
        if(nums[0]!=0 && nums[0]<=newTarget){
            dp[0][nums[0]]=1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                dp[i][j]=take+notTake;
            }
        }

        return dp[nums.length-1][newTarget];
    }
}
class Solution {
    // Space Optimization

    // NOTE
    // yaha array mai zero bhi ho sakta hai
    // toh wahi wala code likhenge

    // Better Approach
    // Let all '+' elements be s1 and '-' elements be s2
    //
    // s1 - s2 = target
    // s1 + s2 = totalSum
    //
    // => s2 = (totalSum - target) / 2
    //
    // So the problem reduces to:
    // Count the number of subsets having sum = newTarget.

    // tc: O(n * newTarget)
    // sc: O(newTarget)

    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int numerator = totalSum - target;

        if (numerator % 2 != 0)
            return 0;
        if (numerator < 0)
            return 0;

        int newTarget = numerator / 2;

        int prev[] = new int[newTarget + 1];

        prev[0] = 1;

        if (nums[0] == 0) {
            prev[0] = 2; // {} , {0}
        }

        // nums[0] != 0 because uss case mai toh hume 2 place karna hai
        if (nums[0] != 0 && nums[0] <= newTarget) {
            prev[nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {

            int curr[] = new int[newTarget + 1];

            for (int j = 0; j <= newTarget; j++) {

                int notTake = prev[j];

                int take = 0;
                if (nums[i] <= j) {
                    take = prev[j - nums[i]];
                }

                curr[j] = take + notTake;
            }

            prev = curr;
        }

        return prev[newTarget];
    }
}