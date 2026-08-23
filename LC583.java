class Solution {
    // Approach 
    // LCS length nikalo
    // Characters not part of LCS need to be removed from one string
    // numOfDeletionsInS1=s1.length()-LCS.length() -> number of chars not contributing to LCS
    // numOfDeletionsInS2=s2.length()-LCS.length() number of chars not contributing to LCS
    // ans=> addition of both
    // simplified version =(s1.length()+s1.length())-2*Lcs.length()
    
    // Tabulation
    // Same way memoization can be done
    // TC: O(n*m)
    // SC: O(n*m)
    public int minDistance(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return (s1.length()+s2.length())-2*dp[s1.length()][s2.length()];
    }
}