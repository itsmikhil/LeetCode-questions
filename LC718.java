class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Longest subsequence ke baad karna 
        // kaafi easy hai
        // yaha pe hum not equal chars pe zero he rakhte hai
        // unlike the case in subsequence problem
        // tc = n2
        // sc=n2
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        int max=0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                // jo zero wali row col hai usko initailiza karne ke liye
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    if(nums1[i-1]==nums2[j-1]){
                        dp[i][j]=1+dp[i-1][j-1];
                        max=Math.max(max,dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}