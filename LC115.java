class Solution {
    // 1 indexed hai -> Note -> Like LCS
    // Memoization
    // "TRY ALL POSSIBLE WAYS" -> MANTRA

    // this is LCS with take and notTake
    // 
    // in case of match:
    // path1: take (i-1,j-1)
    // path2: notTake and wait for another (i-1,j)

    // in case of mismatch:
    // obvio notTake (i-1,j)
    int helper(String s,String t,int dp[][],int i,int j){

        // note j base case will come before i base case 
        // because ho skata hai i==0 pe he j==0 bhi jaye toh ye valid case hoga
        
        // agar second string puri khtam matlab sab match ho chuka hai
        // so its a valid case
        if(j==0){
            return 1;
        }
        // agar first string puri khtam ho gayi hai and still hume subseq nhi mila hai
        // matlab invalid case
        if(i==0){
            return 0;
        }
        // overlapping subproblem
        if(dp[i][j]!=-1) return dp[i][j];

        // MATCH CASE:
        // path1:- jo curr char mathc hua hai usse le lo
        // path2:- skip karo first string ko aage badao
        // aage milega tabhi match karne ka try karenge
        if(s.charAt(i-1)==t.charAt(j-1)){
            dp[i][j]=helper(s,t,dp,i-1,j-1)+helper(s,t,dp,i-1,j);
        }else{
            // match he nhi hua hai toh first string ka pointer move karenge
            dp[i][j]=helper(s,t,dp,i-1,j);
        }

        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()+1][t.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(s,t,dp,s.length(),t.length());
    }
}
class Solution {
    // 1 indexed hai -> Note -> Like LCS
    // Tabulation
    // "TRY ALL POSSIBLE WAYS" -> MANTRA

    // this is LCS with take and notTake
    // 
    // in case of match:
    // path1: take (i-1,j-1)
    // path2: notTake and wait for another (i-1,j)

    // in case of mismatch:
    // obvio notTake (i-1,j)
    
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()+1][t.length()+1];

        // mempization ka pehla case
        // jaise he j=0 aagaye matalb second string puri mil chuki hai
        // valid case 
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }

        // pehli string khatam ho gayi hai matalb invalid case
        // iska loop hum j=1 se start karenge waran dp[0][0] jisko humne upar 1 set kiya tha
        // woh overwrite ho jayega
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
class Solution {
    // 1 indexed hai -> Note -> Like LCS
    // Space optimization
    // we observe that our curr row only needs prev row for computation -> IDEA
    // "TRY ALL POSSIBLE WAYS" -> MANTRA

    // this is LCS with take and notTake
    // 
    // in case of match:
    // path1: take (i-1,j-1)
    // path2: notTake and wait for another (i-1,j)

    // in case of mismatch:
    // obvio notTake (i-1,j)

    public int numDistinct(String s, String t) {
        int prev[]=new int[t.length()+1];

        // mempization ka pehla case
        // jaise he j=0 aagaye matalb second string puri mil chuki hai
        // valid case 
        prev[0]=1;
        

        for(int i=1;i<=s.length();i++){
            int curr[]=new int[t.length()+1];
            // mempization ka pehla case
            // jaise he j=0 aagaye matalb second string puri mil chuki hai
            // valid case 
            curr[0]=1;
            for(int j=1;j<prev.length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j]=prev[j-1]+prev[j];
                }else{
                    curr[j]=prev[j];
                }
            }
            prev=curr;
        }

        return prev[t.length()];
    }
}