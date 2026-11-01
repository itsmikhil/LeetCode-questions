class Solution {
    public int minMoves(int[] nums) {

        // brute force
        // haar baar n-1 els ko plus 1 karo
        // greedy approach 
        // jo bhi curr arr mai max El hoga uske alawa jo bhi n-1 els honge usse +1 karenge
        // [1,2,3(max)]->[2,3,3(max)]->[3,4(max),3]->[4,4,4] 
        // this is n^2 approach -> TLE

        // another obervation
        // maxEl ke alawa hum baaki sabko plus 1 kare
        // uske badle kyu na hum khaali maxEL ko minus 1 kare
        // same he baat hai na
        // [1,2,3(max)]->[1,2,2(max)]->[1,2(max),1]->[1,1,1]
        
        // we note that we are trying to make every el equal ko minEL in array
        // by decrement 1 each time

        // toh 3 ko 1 banane ke liye 2 steps
        // 2 ko 1 banane ke liye 1 step

        // bass question cracked
        // find minEl in array
        // ans+=(otherElInArr - minEl) -> nothing but decrement steps

        


        int ans=0;
        int minEl=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minEl){
                minEl=nums[i];
            }
        }
        for(int el:nums){
            ans+=(el-minEl);
        }
        return ans;
    }
}