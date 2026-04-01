class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],0);
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]+diff) && map.containsKey(nums[i]+2*diff)){
                count++;
            }
        }
        return count;
        
    }
}