class Solution {
    
    static int helper(int arr[],int dp[][],int i,int j){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps=helper(arr,dp,i,k)+helper(arr,dp,k+1,j)+arr[i-1]*arr[k]*arr[j];
            min=Math.min(steps,min);
        }
        return dp[i][j]=min;
    }
    static int matrixMultiplication(int arr[]) {
        int dp[][]=new int[arr.length][arr.length];
        
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return helper(arr,dp,1,arr.length-1);
    }
}

class Solution {
    
    
    static int matrixMultiplication(int arr[]) {
        int dp[][]=new int[arr.length][arr.length];
        // length-1 because n is number of matrices
        // if n dimensions are given means n-1 matrixs
        
        int n=arr.length-1;
        
        // base case
        for(int i=0;i<dp.length;i++){
            dp[i][i]=0;
        }
        
        // note the loops
        // only upper triangular region is getting calculated
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<=n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    min=Math.min(steps,min);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n];
    }
}