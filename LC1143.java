// class Solution {
//     int longestLength(String s1,String s2,int idx1,int idx2){
//         if(idx1>=s1.length() || idx2>=s2.length()) return 0;
//         // agar char common mila toh dono se woh char hata diya aur subsequence ke length mai +1 kiya
//         if(s1.charAt(idx1)==s2.charAt(idx2)){
//             return 1+longestLength(s1,s2,idx1+1,idx2+1);
//         }else{
//             // agar common nhi hai 
//             // left mai se ek char hataya aur right ko as it is rehene diya
//             // right mai se ek char hataya aur left ko as it is rehene diya
//             // because hp sakta hai ek charcter obstacle ho lekin usko hatate he jackpot mile
//             // (abc,dbc)
//             // /        \
//             // (bc,dbc) (abc,bc)
//             return Math.max(longestLength(s1,s2,idx1+1,idx2),longestLength(s1,s2,idx1,idx2+1));
//         }
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return longestLength(text1,text2,0,0);
//     }
// }
class Solution {
    // Better
    // Memoization
    // Tc:o(n*m)
    // Sc: o(n*m)
    int longestLength(String s1,String s2,int idx1,int idx2,int dp[][]){
        if(idx1>=s1.length() || idx2>=s2.length()) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return dp[idx1][idx2]= 1+longestLength(s1,s2,idx1+1,idx2+1,dp);
        }else{
            return dp[idx1][idx2]= Math.max(longestLength(s1,s2,idx1+1,idx2,dp),longestLength(s1,s2,idx1,idx2+1,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return longestLength(text1,text2,0,0,dp);
    }
}


class Solution {
    // Optimal
    // Tabulation
    // Tc:o(n*m)
    // Sc: o(n*m)
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}