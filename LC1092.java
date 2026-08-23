class Solution {
    // dry run on pg -> 125

    // Approach:
    // pehle lCS se table bana lo
    // fir in case of equal char -> include the character in Supersequence and move diagonally
    // in case of unequal char include the shorter(lesser value in lcs table) character in Supersequence and move in direction of larger chara(higher value in lcs table)
    // After one string gets exhausted, append remaining characters. -> DONT FORGET
    
    // NOTE:
    // memoization nhi use kar sakte because 
    // usme sirf jo cell ki zarurat hai sirf wahi compute hoti hai
    // jabki tabulation mai saare cells ki value compute hoti hai
    // aur yaha pe hume saare cells because hume compare karke Supersequence banana hai

    // tabulation
    // TC: O(n*m)
    // SC: O(n*m)
    public String shortestCommonSupersequence(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
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
        StringBuilder str=new StringBuilder();
        int i=s1.length();
        int j=s2.length();
        while(i>0 && j>0){
            // include the common char move diagonally
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                str.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                // take the smaller element and move in direction of bigger element
                if(dp[i][j]==dp[i-1][j]){
                    str.append(s1.charAt(i-1));
                    i--;
                }else{
                    str.append(s2.charAt(j-1));
                    j--;
                }
            }
        }

        // After one string gets exhausted, append remaining characters. -> DONT FORGET
        while(i>0){
            str.append(s1.charAt(i-1));
            i--;
        }

        while(j>0){
            str.append(s2.charAt(j-1));
            j--;
        }
        return str.reverse().toString();
    }
}