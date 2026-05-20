class Solution {
    public int findKRotation(int nums[]) {
        // similar to Find out how many times the array is rotated
        int min=Integer.MAX_VALUE;
        int idx=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[start]<=nums[mid]){
                if(nums[start]<min){
                    min=nums[start];
                    idx=start;
                }
                start=mid+1;
            }else{
                if(nums[mid]<min){
                    min=nums[mid];
                    idx=mid;
                }
                end=mid-1;
            }
        }
        return idx;
        
    }
}