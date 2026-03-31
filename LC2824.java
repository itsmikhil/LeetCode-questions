class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // brute force toh hai he
        // this is something new===> badiya approach hai
        Collections.sort(nums);
        int count=0;
        int left=0;
        int right=nums.size()-1;
        while(left<right){
            if(nums.get(left)+nums.get(right)<target){
                count+=(right-left);
                left++;
            }else{
                right--;
            }
        }
        return count;
    }
}