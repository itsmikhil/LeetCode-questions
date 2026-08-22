class Solution {
    // agar char common mila toh dono se woh char hata diya aur subsequence ke length mai +1 kiya
    // agar common nhi hai 
    // left mai se ek char hataya aur right ko as it is rehene diya
    // right mai se ek char hataya aur left ko as it is rehene diya
    // because hp sakta hai ek charcter obstacle ho lekin usko hatate he jackpot mile
    //              (abc,dbc)
    //             /        \
    //             (bc,dbc)(abc,bc)
    int longestLength(String text1,String text2,int dp[][],int i,int j){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]=1+longestLength(text1,text2,dp,i-1,j-1);
        }else{
            dp[i][j]=Math.max(longestLength(text1,text2,dp,i-1,j),longestLength(text1,text2,dp,i,j-1));
        }
        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);
        return longestLength(text1, text2, dp, text1.length(), text2.length());
    }
}

class Solution {
    // agar char common mila toh dono se woh char hata diya aur subsequence ke length mai +1 kiya
    // agar common nhi hai 
    // left mai se ek char hataya aur right ko as it is rehene diya
    // right mai se ek char hataya aur left ko as it is rehene diya
    // because hp sakta hai ek charcter obstacle ho lekin usko hatate he jackpot mile
    //              (abc,dbc)
    //             /        \
    //             (bc,dbc)(abc,bc)
    // int longestLength(String text1,String text2,int dp[][],int i,int j){
    //     if(i==0 || j==0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(text1.charAt(i-1)==text2.charAt(j-1)){
    //         dp[i][j]=1+longestLength(text1,text2,dp,i-1,j-1);
    //     }else{
    //         dp[i][j]=Math.max(longestLength(text1,text2,dp,i-1,j),longestLength(text1,text2,dp,i,j-1));
    //     }
    //     return dp[i][j];
    // }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
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

        // Printing LCS
        // kaha se aaye hai bass trace karte chalo
        int i=text1.length();
        int j=text2.length();
        StringBuilder str=new StringBuilder();
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                str.append(text1.charAt(i-1));
                i=i-1;
                j=j-1;
            }else{
                if(dp[i][j]==dp[i-1][j]){
                    i=i-1;
                    j=j;
                }else{
                    i=i;
                    j=j-1;
                }
            }
        }

        str.reverse();
        // System.out.println(str.toString());

        return dp[text1.length()][text2.length()];
    }
}