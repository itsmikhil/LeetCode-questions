class Solution {
    // Approach 
    // LCS lagao(s,s.reverse())
    // usse hume longoest common palindrmoic subsequence ki length milegi
    // abb jo value aayegi woh chars deti hai toj palindrome bana rahe hai
    // agar hum woh chars jo bach gaye unhe as it is dusre half mai add kar denge toh palindroe ban jayega
    // toh wahi logic hai s-lengthOfLongestPalindromicSubsequnece

    // Example:
    // s = "mbadm"
    //
    // reverse(s) = "mdabm"
    //
    // LCS("mbadm", "mdabm") = "mad" (length = 3)
    // Longest Palindromic Subsequence = "mad"
    //
    // Characters left = 5 - 3 = 2
    //
    // We can insert 'a' and 'm': -> not palindrome nhi form karne wale chars toh dusre half mai add kar diya so that palindrome ban jaye
    // "mbadm" -> "mbadabm"

    // same approach for memoization as well
    // tabulation
    // tc:(n*n)
    // sc:(n*n)
    public int minInsertions(String s) {
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

        return s.length()-dp[s.length()][s.length()];
    }
}