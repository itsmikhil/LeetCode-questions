class Solution {
    // memoization
    // DRY RUN & rec tree-> in notebook pg122

    // jab bhi "Infinite Supply" ho toh bhi ek ek karke lena  --> MANTRA
    // why ?
    // eg {2,3} target=25
    // agar hum max lenge toh we can take 8 coins of 3 => 8*3=>24
    // leftover =25-24=>1 which becomes invalid
    // isliye agar humne ek ek karke liya hota toh
    // we should have taken 7 coins of 3 and 2 coins of 2 for valid ans
    // 25=> (3*7)+(2*2)

    // isliye iss case mai idx pointer sirf NOTTake  case mai he move hoga
    // neeche code dekho

    // tc: (n*sum)
    // sc:(n*sum)+(numOfCoins)(recursive stack)
    int helper(int nums[],int dp[][],int i,int sum){
        if(sum==0){
            return 0;
        }

        // i==0 ke case mai
        // aur koyi option he nhi hai aage ka
        // isliye agar divisble hai toh uske accoring coins lelo
        // warna ye invalid case hogaya
        if(i==0){
            if(sum%nums[0]==0){
                return sum/nums[0];
            }else{
                // we are returning 1e9 instead of INT_MAX because 
                // 1+INT_MAX overflow kar jaayega -> jab woh kisi TAKE wale case se add hoga prev call mai
                // isliye 1e9 liya hai
                return (int)1e9;
            }
        }

        if(dp[i][sum]!=-1) return dp[i][sum];

        // sirf yaha pe he pointer move kar rahe hai
        int notTake=0+helper(nums,dp,i-1,sum);

        // ek ek karke le rahe hai
        // and pointer move nhi kar rahe hai
        int take=(int)1e9;
        if(nums[i]<=sum){
            take=1+helper(nums,dp,i,sum-nums[i]);
        }

        return dp[i][sum]=Math.min(notTake,take);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans=helper(coins,dp,coins.length-1,amount);
        
        // no possible ans
        if(ans>=(int)1e9){
            return -1;
        }

        return ans;
    }
}

class Solution {
    // Tabulation
    // DRY RUN & rec tree-> in notebook pg122

    // jab bhi "Infinite Supply" ho toh bhi ek ek karke lena  --> MANTRA
    // why ?
    // eg {2,3} target=25
    // agar hum max lenge toh we can take 8 coins of 3 => 8*3=>24
    // leftover =25-24=>1 which becomes invalid
    // isliye agar humne ek ek karke liya hota toh
    // we should have taken 7 coins of 3 and 2 coins of 2 for valid ans
    // 25=> (3*7)+(2*2)

    // isliye iss case mai idx pointer sirf NOTTake  case mai he move hoga
    // neeche code dekho

    // tc: (n*sum)
    // sc:(n*sum)
    
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        
        // ye wahi base case he jo humne memoization mai likha tha
        for(int sum=0;sum<dp[0].length;sum++){
            if(sum%coins[0]==0){
                dp[0][sum]=sum/coins[0];
            }else{
                dp[0][sum]=(int)(1e9);
            }
        }

        // note inner loop starts from j 
        // as we are not pre processing it because its not needed
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){

                int notTake=dp[i-1][j];

                int take=(int)(1e9);
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }

                dp[i][j]=Math.min(take,notTake);
            }
        }

        int ans=dp[coins.length-1][amount];

        if(ans>=(int)1e9){
            return -1;
        }

        return ans;
        
    }
}
class Solution {
    // Space Optimization -> wahi prev and curr
    // DRY RUN & rec tree-> in notebook pg122

    // jab bhi "Infinite Supply" ho toh bhi ek ek karke lena  --> MANTRA
    // why ?
    // eg {2,3} target=25
    // agar hum max lenge toh we can take 8 coins of 3 => 8*3=>24
    // leftover =25-24=>1 which becomes invalid
    // isliye agar humne ek ek karke liya hota toh
    // we should have taken 7 coins of 3 and 2 coins of 2 for valid ans
    // 25=> (3*7)+(2*2)

    // isliye iss case mai idx pointer sirf NOTTake  case mai he move hoga
    // neeche code dekho

    // tc: (n*sum)
    // sc:(n*sum)
    
    public int coinChange(int[] coins, int amount) {
        int prev[]=new int[amount+1];
        
        // ye wahi base case he jo humne memoization mai likha tha
        // initially prev is 0th row
        for(int sum=0;sum<prev.length;sum++){
            if(sum%coins[0]==0){
                prev[sum]=sum/coins[0];
            }else{
                prev[sum]=(int)(1e9);
            }
        }

        // note inner loop starts from j 
        // as we are not pre processing it because its not needed
        for(int i=1;i<coins.length;i++){
            int curr[]=new int[amount+1];
            for(int j=0;j<prev.length;j++){

                int notTake=prev[j];

                int take=(int)(1e9);
                // note yaha curr use hota hai because we use Ith row and I-1 row
                if(coins[i]<=j){
                    take=1+curr[j-coins[i]];
                }

                curr[j]=Math.min(take,notTake);
            }
            prev=curr;
        }

        int ans=prev[amount];

        if(ans>=(int)1e9){
            return -1;
        }

        return ans;
        
    }
}