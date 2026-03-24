class Solution {
    static boolean func(int n,int arr[],int k,int curr,int sum){
        if(sum==k){
            return true;
        }else if(sum>k){
            return false;
        }else if(curr>=n){
            return false;
        }
        // take this el case || not take thsi el case
        return func(n,arr,k,curr+1,sum+arr[curr])||func(n,arr,k,curr+1,sum);
    }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return func(N,arr,K,0,0);
    }
}