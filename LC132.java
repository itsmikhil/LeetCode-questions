class Solution {

    // dry run on pg140
    boolean isPalindrome(String s,int start,int end){
        int i=start;
        int j=end;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    int solve(String s,int idx,int dp[]){
        if(idx==s.length()){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int min=Integer.MAX_VALUE;
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                // current palindrome ko 1 partition maan lo
                // aur aage ka answer solve karo
                // basically: 1 + solveForAhead()
                int numOfPartitions=1+solve(s,i+1,dp);

                // saare possible partitions mai se minimum wala lo
                min=Math.min(numOfPartitions,min);
            }
        }
        dp[idx]=min;
        return dp[idx];
    }
    public int minCut(String s) {
        int dp[]=new int[s.length()];

        Arrays.fill(dp,-1);

        // solve() actually minimum partitions bata raha hai
        // but hume minimum CUTS chahiye
        // partitions = cuts + 1
        // so answer se 1 minus kar do
        int ans=solve(s,0,dp);
        return ans!=Integer.MAX_VALUE?ans-1:-1;
    }
}