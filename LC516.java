class Solution {
    // call LCS(string,string.reverse())
    // tabulation
    // tc:(n*n)
    // sc:(n*n)
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int dp[][]=new int[s.length()+1][s.length()+1];
        
        // base case
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for(int j=0;j<dp.length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[s.length()][s.length()];
    }
}