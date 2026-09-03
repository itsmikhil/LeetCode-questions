class Solution {
    // dry run on pg 135
    // [2 1 5 4 3 0 0]
    // step 1 : [2 1 // 5 4 3 0 0]
    // step 2: [2 (1) // 5 4 (3) 0 0]
    // step 3: [2 (3) // 5 4 (1) 0 0]
    // step 4:  [2 (3) // 0 0 1 4 5]
    int[] reverse(int nums[]){
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums;
    }
    int[] reverse(int nums[],int startIdx){
        int start=startIdx;
        int end=nums.length-1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
        return nums;
    }

    void swap(int nums[],int idx1,int idx2){
        int temp=nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }

    public void nextPermutation(int[] nums) {

        // step 1 finding the first idx where nums[i]<nums[i+1]
        int idx=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        // if it stays minus 1 means
        // nums=[3 2 1]
        // its next permutation is [1 2 3]
        if(idx==-1){
            reverse(nums);
            return;
        }
        // step 2
        // the number which is just greater then el at idx
        // the second half is obvio in descending order thats why
        // it takes time to find idx el
        int justBiggerNumberInSecondHalfIdx=-1;
        for(int i=nums.length-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                justBiggerNumberInSecondHalfIdx=i;
                break;
            }
        }

        // step 3
        // swap both the els
        swap(nums,justBiggerNumberInSecondHalfIdx,idx);

        // step 4
        // reverse the seond half
        reverse(nums,idx+1);
        return;
    }
}