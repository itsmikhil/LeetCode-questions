
// all three approaches in leetcode
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // now we cant reduce space complexity further
        // so we will reduce time complexity --> here it becomes O(n)
        // pointers for nums array
        int left=0;
        int right=nums.length-1;
        int ans[]=new int[nums.length];
        // pointers for ans array
        int i=0;
        int j=ans.length-1;
        for(;left<nums.length && right>=0;left++,right--){
            if(nums[left]<pivot){
                ans[i]=nums[left];
                i++;
            }
            if(nums[right]>pivot){
                ans[j]=nums[right];
                j--;
            }
        }
        while(i<=j){
            ans[i]=pivot;
            i++;
        }
        return ans;
    }
}