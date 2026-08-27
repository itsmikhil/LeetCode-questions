class Solution {

    // try all possible cases  -> our mantra

    // Time Complexity: O(m × n)
    // Space Complexity: O(m × n) + (recursive stack)

    int helper(String s1,String s2,int dp[][],int i,int j){
        // agar str1 empty hogayi toh
        // insert all remaining chars in str2 to make it like str2
        // therefore return j operations
        if(i<=0){
            return j;
        }

        // agar str2 empty hogayi toh
        // delete all remaining chars in str1 to make it like str2(empty string)
        // therefore return i operations
        if(j<=0){
            return i;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        // agar match hogaya toh no extra effort
        // 0 + (i-1,j-1)
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]=0+helper(s1,s2,dp,i-1,j-1);
        }else{
            
            // hypothetically humne ek char insert kiya string 1 ke iTH place pe
            // aur woh match kar gaya string 2 ke jth char se match kar gaya
            // i and j on last char of string
            // horse(i)=> str1 ros(j) => str2
            // horse(i)s-> str1 ros(j)-> str2
            // match hogaya inserted char se
            // toh (i,j-1)
            int insert=1+helper(s1,s2,dp,i,j-1);
            
            // delete curr char in str1
            // i-1,j
            int delete=1+helper(s1,s2,dp,i-1,j);

            // Replace the current character of string1
            // with the current character of string2.
            // Both characters are now processed.
            // (i-1, j-1)
            int replace=1+helper(s1,s2,dp,i-1,j-1);
            
            // return minimum of all cases
            return dp[i][j]=Math.min(insert,Math.min(delete,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(word1,word2,dp,word1.length(),word2.length());
    }
}
class Solution {

    // try all possible cases  -> our mantra

    // Time Complexity: O(m × n)
    // Space Complexity: O(m × n) 
    public int minDistance(String word1, String word2) {
        int dp[][]=new int[word1.length()+1][word2.length()+1];

        // first base case of memoization
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }
        
        // second base case of memoization
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=0+dp[i-1][j-1];
                }else{
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(insert,Math.min(delete,replace));
                }
            }
        }


        return dp[word1.length()][word2.length()];
    }
}