class Solution {
    public int subarraySum(int[] nums, int k) {
        // imp question and imp approach
        // iska toh video he dekh lo better rahega 
        HashMap<Integer,Integer> map=new HashMap<>();
        // note why we do this
        map.put(0,1);
        int currSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-k)){
                // note why we do this
                count+=map.get(currSum-k);
            }
            if(map.containsKey(currSum)){
                map.put(currSum,map.get(currSum)+1);
            }else{
                map.put(currSum,1);
            }
        }
        return count;
    }
}