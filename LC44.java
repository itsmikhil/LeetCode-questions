class Solution {
    // s has only lowercase chars
    // p has lowercase chars,*,?

    // for understand * 
    // should be assume it to be empty char or series of chars(1 char,2char,3char...)
    // see tree how we are taking both cases of empty string and only series of chars
    // we dont know how many chars should we match so we try for all

    // Example:
    // s = "abcdef"
    // p = "ab*"
    //
    //                     abcdef | ab*
    //                           *
    //                     /             \
    //         '*' matches char      '*' matches empty
    //          abcde | ab*           abcdef | ab
    //               *                    X (f != b)
    //          /         \
    //     abcd | ab*   abcde | ab
    //          *            X (e != b)
    //      /       \
    //  abc | ab*  abcd | ab
    //       *          X (d != b)
    //    /      \
    // ab | ab*  abc | ab
    //     *         X (c != b)
    //  /      \
    // "" | ab*   ab | ab
    //            |
    //         match a,b
    //            |
    //          "" | ""
    //            ✓
    //
    // Left branch : helper(i-1, j) -> '*' matches one/more characters
    // Right branch: helper(i, j-1) -> '*' matches empty string
    
    boolean allStars(String s,String p,int i,int j){
        while(j!=0){
            if(p.charAt(j-1)!='*' ){
                return false;
            }
            j--;
        }
        return true;
    }
    boolean helper(String s,String p,int dp[][],int i,int j){
        // agar string aur pattern dono khtam matalb valid case
        if(i<=0 && j<=0) return true;

        // agar string bacha hai and pattern khatam matlab invalid case
        if(i>0 && j<=0) return false;

        if(dp[i][j]!=-1) return dp[i][j]==1?true:false;
        // agar string khtam hai and pattern bacha hai
        // then it can only be true when only stars are there in patter
        // s="" p="****"
        if(i<=0 && j>0){
            dp[i][j] = allStars(s,p,i,j) ? 1 : 0;
            return dp[i][j] == 1;
        }

        // if curr chars match -> check next char
        if(s.charAt(i-1)==p.charAt(j-1)){
            dp[i][j] = helper(s,p,dp,i-1,j-1) ? 1 : 0;
            return dp[i][j] == 1;

            // ? matches any char
        }else if(p.charAt(j-1)=='?'){
            dp[i][j] = helper(s,p,dp,i-1,j-1) ? 1 : 0;
            return dp[i][j] == 1;

            // * means there can be 2 cases
            // either we take it as empty char or as a series of chars
        }else if(p.charAt(j-1)=='*'){
            dp[i][j] = (helper(s,p,dp,i-1,j) || helper(s,p,dp,i,j-1)) ? 1 : 0;
            return dp[i][j] == 1;
        }else{
            // any other case is false
            dp[i][j] = 0;
            return false;
        }

    }
    public boolean isMatch(String s, String p) {
        int dp[][]=new int[s.length()+1][p.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(s,p,dp,s.length(),p.length());
    }
}
class Solution {

    // Checks whether pattern[0...j-1] contains only '*'
    boolean allStars(String p, int j) {
        while (j != 0) {
            if (p.charAt(j - 1) != '*')
                return false;
            j--;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        // both string and pattern are empty
        dp[0][0] = true;
        
        // pattern empty but string remains
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        // string empty but pattern remains
        for (int j = 1; j <= m; j++) {
            dp[0][j] = allStars(p, j);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // characters match
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '?' matches any one character
                else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*' matches empty or one/more characters
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

                // mismatch
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}