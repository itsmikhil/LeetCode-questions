class Solution {
    // memoization
    // we need to call only cells because we are not going ahead in unequal case ->NOTE
    // we keep a ans var which gives track of max
    // if equal then only plus 1
    // otherwise 0
    
    // Time Complexity:  O(n * m)

    // Space Complexity: O(n * m) + o(length of common substring)(recursive stack)
    static int helper(String s1, String s2,int dp[][],int i,int j,int ans[]){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j]=1+helper(s1,s2,dp,i-1,j-1,ans);
            ans[0]=Math.max(ans[0],dp[i][j]);
        }else{
            dp[i][j]=0;
        }
        return dp[i][j];
    }
    public int longCommSubstr(String s1, String s2) {

        int dp[][]=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans[]=new int[1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                helper(s1,s2,dp,i,j,ans);
            }
        }

        return ans[0];
    }
}
class Solution {
    // tabulation
    // we need to call only cells because we are not going ahead in unequal case ->NOTE
    // we keep a ans var which gives track of max
    // if equal then only plus 1
    // otherwise 0
    
    // Time Complexity:  O(n * m)

    // Space Complexity: O(n * m) 
    
    public int longCommSubstr(String s1, String s2) {

        int dp[][]=new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        int ans[]=new int[1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans[0]=Math.max(ans[0],dp[i][j]);
                }
            }
        }

        return ans[0];
    }
}

class Solution {
    // Space Optmixation using prev and curr
    // we keep a ans var which gives track of max
    // if equal then only plus 1
    // otherwise 0
    
    // Time Complexity:  O(n * m)

    // Space Complexity: O( m) 
    
    public int longCommSubstr(String s1, String s2) {
        
        // NOTE sirf second string ki length ka bana rahe hai
        int prev[]=new int[s2.length()+1];
        prev[0]=0;

        int ans[]=new int[1];

        for(int i=1;i<=s1.length();i++){
            int curr[]=new int[s2.length()+1];
            curr[0]=0;
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                    ans[0]=Math.max(ans[0],curr[j]);
                }
            }
            prev=curr;
        }

        return ans[0];
    }
}