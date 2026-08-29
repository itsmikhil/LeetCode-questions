class Solution {
    // MANTRA :- "TRY ALL POSSIBLE WAYS"
    // we need to keep track of prev el we took so that our next el is greater then it
    // initailly prev-> -1
    // and in dp array we cant stire at -1 idx
    // thats why we store at prevIdx+1 -> NOTE

    // tc: (n*n)
    // sc: (n*n) + (recursive stack space)

    int helper(int nums[],int dp[][],int i,int prevIdx){

        if(i==nums.length){
            return 0;
        }

        if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];

        // ye wala rehne do aage dekhenge
        // kuch nhi le rahe toh prevIdx stays same
        int notTake=0+helper(nums,dp,i+1,prevIdx);
        
        // if prevIdx==-1 means we havent taken anything yet
        // and second condition is what we need to follow as per question
        // curr Idx becomes prevIdx for next iteration
        int take=Integer.MIN_VALUE;
        if(prevIdx==-1 || nums[i]>nums[prevIdx]){
            take=1+helper(nums,dp,i+1,i);
        }

        return dp[i][prevIdx+1]=Math.max(notTake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // woh prevIdxp + 1  pe store karne ki wajah se n+1 length ka array
        int dp[][]=new int[nums.length][nums.length+1];
        
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums,dp,0,-1);
    }
}

class Solution {
    // tabulation
    // MANTRA :- "TRY ALL POSSIBLE WAYS"
    // we need to keep track of prev el we took so that our next el is greater then it
    // initailly prev-> -1
    // and in dp array we cant stire at -1 idx
    // thats why we store at prevIdx+1 -> NOTE

    // tc: (n*n)
    // sc: (n*n) 

    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // woh prevIdxp + 1  pe store karne ki wajah se n+1 length ka array
        int dp[][]=new int[nums.length+1][nums.length+1];
        
        // nums.length+1 liya hai isliye so that we can store base case
        for(int j=0;j<dp[0].length;j++){
            dp[n][j]=0;
        }
        
        // NOTE
        // yaha pe because we are using shifted coordinates for prevIDX
        // isliye haar jagah neeche plus 1 hoga while acccess prevIDX in DP array
        for(int i=n-1;i>=0;i--){
            for(int prevIdx=i-1;prevIdx>=-1;prevIdx--){

                // ye wala rehne do aage dekhenge
                // kuch nhi le rahe toh prevIdx stays same
                int notTake=0+dp[i+1][prevIdx+1];
                
                // if prevIdx==-1 means we havent taken anything yet
                // and second condition is what we need to follow as per question
                // curr Idx becomes prevIdx for next iteration
                int take=Integer.MIN_VALUE;
                if(prevIdx==-1 || nums[i]>nums[prevIdx]){
                    take=1+dp[i+1][i+1];
                }

                dp[i][prevIdx+1]=Math.max(notTake,take);
            }
        }

        return dp[0][-1 + 1];
    }
}
class Solution {
    // Space Optimization
    // our curr state only depends on prev state
    
    // MANTRA :- "TRY ALL POSSIBLE WAYS"
    // we need to keep track of prev el we took so that our next el is greater then it
    // initailly prev-> -1
    // and in dp array we cant stire at -1 idx
    // thats why we store at prevIdx+1 -> NOTE

    // tc: (n*n)
    // sc: 2*(n+1) 

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // woh prevIdxp + 1  pe store karne ki wajah se n+1 length ka array
        int prev[]=new int[n+1];
        
        // nums.length+1 liya hai isliye so that we can store base case
        for(int j=0;j<prev.length;j++){
            prev[j]=0;
        }

        // NOTE
        // yaha pe because we are using shifted coordinates for prevIDX
        // isliye haar jagah neeche plus 1 hoga while acccess prevIDX in DP array
        for(int i=n-1;i>=0;i--){
            int curr[]=new int[n+1];
            for(int prevIdx=i-1;prevIdx>=-1;prevIdx--){

                // ye wala rehne do aage dekhenge
                // kuch nhi le rahe toh prevIdx stays same
                int notTake=0+prev[prevIdx+1];
                
                // if prevIdx==-1 means we havent taken anything yet
                // and second condition is what we need to follow as per question
                // curr Idx becomes prevIdx for next iteration
                int take=Integer.MIN_VALUE;
                if(prevIdx==-1 || nums[i]>nums[prevIdx]){
                    take=1+prev[i+1];
                }

                curr[prevIdx+1]=Math.max(notTake,take);
            }
            prev=curr;
        }

        return prev[-1 + 1];
    }
}
class Solution {
    // Algorithmic -> for printing subsequence -> dry run on 128

    // dp[i]-> length of LIS ending at I  ----> IMP

    // 11 has seq of 1,11
    // if 16 forms sequence with 16 becuase 11<16
    // then it will automatically form sequnece with 1 also 
    // 11 ke saath wale usse chote he honge [1,11,16]
    // bas wahi kar rahe hai

    // aur printing ke liye hum parent store kar rahe hai in HASH array

    // tc: (n^2)
    // sc: (n) 

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        int hash[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(hash, -1);

        int maxLen = 1;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i - 1; j++) {

                if (nums[j] < nums[i]) {

                    int currLen = 1 + dp[j];

                    if (currLen > dp[i]) {
                        dp[i] = currLen;
                        hash[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // for printing
        int ans[] = new int[maxLen];
        int i = ans.length - 1;

        int currIdx = maxIdx;
        while (currIdx != -1) {
            ans[i] = nums[currIdx];
            i--;
            currIdx = hash[currIdx];
        }

        // System.out.println(ans);
        return maxLen;
    }
}