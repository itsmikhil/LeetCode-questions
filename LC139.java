class Solution {

    // dp[i] = 1 if the substring s[i...] can be completely
    //         broken into words from wordDict
    //       = 0 if it cannot be broken
    //       = -1 if we have not calculated it yet

    // basic backtracking ko memoize kiya hai
    // saare substring try karo

    // backtracking very intuitive
    // memoization thodha samjh lo
    boolean helper(String s,List<String> wordDict,int dp[],int idx){
        if(idx==s.length()){
            return true;
        }

        if(dp[idx]!=-1){
            return dp[idx]==1?true:false;
        }

        for(int i=idx;i<s.length();i++){
            String str=s.substring(idx,i+1);

            if(wordDict.contains(str)){
                // aage wale idx se check karo agar woh wale words bhi dict mai hai ya nhi
                boolean ans=helper(s,wordDict,dp,i+1);

                if(ans==true){
                    dp[idx]=1;
                    return ans;
                }
            }
        }

        dp[idx]=0;
        return false;
    }

    public boolean wordBreak(String s,List<String> wordDict){
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);

        return helper(s,wordDict,dp,0);
    }
}