class Solution {
    // understand question first
    // [a,b,c,d] -> agar ye ans hai toh isme se koyi bhi do ko chose karenge toh 
    // woh ek dusre se divisible hone chaiye

    // inspired from ALGORITHMIC code of LIS
    // first we will sort the array
    // then we will store ki iTH tak kitni log hai peeche jo divisble hai
    // if [2,16]
    // and [16,32]
    // then 32 is obvioously divisible by 2
    // LEGIT bas wahi kar hai 
    public List<Int eger> largestDivisibleSubset(int[] nums) {
        // so every possible divisor comes before its multiples
        // this lets us build the answer from left to right like LIS
        Arrays.sort(nums);
        int n=nums.length;

        int dp[]=new int[n];
        int parent[]=new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);

        int maxLen=1;
        int maxIdx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                int currLen=1+dp[j];
                if(nums[i]%nums[j]==0 && currLen>dp[i]){
                    dp[i]=1+dp[j];
                    parent[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                maxIdx=i;
            }
        }

        int currIdx=maxIdx;
        List<Integer> ans=new ArrayList<>();
        while(currIdx!=-1){
            ans.add(nums[currIdx]);
            currIdx=parent[currIdx];
        }

        Collections.sort(ans);

        return ans;
    }
}