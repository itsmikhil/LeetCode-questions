class Solution {
    int lowerBound(int[] arr, int target) {
        
        // remember start is returned 
        
        int start=0;
        int end=arr.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}
