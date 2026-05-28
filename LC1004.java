class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int max=0;
        int zeros=0;
        while(right<nums.length){
            if(nums[right]==0){
                zeros++;
            }
            // ek zero ko window se nikalenge tabhi he window valid hogi
            while(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            max=Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}