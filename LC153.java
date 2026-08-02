class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            int mid=(start+end)/2;
            // equal to dala because of this case [4, 5, 6, 7, 8, 9, 0, 1, 2, 3]
            // Use <= instead of <.
            // When start == mid (single element left), that half is still sorted.
            // Using < treats it as unsorted and may skip the actual minimum.
            if(nums[start]<=nums[mid]){
                ans=Math.min(ans,nums[start]);
                start=mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                end=mid-1;
            }
        }
        return ans;

    }
}