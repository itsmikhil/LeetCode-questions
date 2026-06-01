class Solution {
    public int jump(int[] nums) {
        // brute->recursion -> exponential -> code dekh lena article se -> TLE
        // better -> DP
        // optimal->o(n)->greeedy range approach

        // treat each range [left,right] as all positions
        // reachable using the current number of jumps

        int left=0;
        int right=0;
        int jumps=0;

        while(right<nums.length-1){

           // find the farthest position reachable
           // from any index in the current range
           int farthest=0;

           for(int j=left;j<=right;j++){
                farthest=Math.max(farthest,j+nums[j]);
           }

            // updating jumps
           jumps++;

           // next range starts after current range
           left=right+1;

           // next range ends at farthest reachable position
           right=farthest;
        }

        return jumps;
    }
}