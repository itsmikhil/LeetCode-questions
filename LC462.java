class Solution {
    public int minMoves2(int[] nums) {
        // Brute force
        // sort the array
        // sab els ko MID element ke jitna bananeke steps count karke return kardo
        
        Arrays.sort(nums);
        int mid=nums[nums.length/2];
        int sum=0;
        for(int el: nums){
            sum+=(Math.abs(mid-el));
        }
        return sum;
    }
}