class Solution {
    // same like Binary Subarrays With Sum and Count number of Nice subarrays
    // optimal -> o(2*2n) ->2 times func call and 2n is in worst case 
    // jab jab exactly k distinct chars bole tab
    // ExactlyK = AtMost(K) - AtMost(K - 1) --->  IMPPP
    // abb toh aasan lagne laga hai
    int numOfSubarraysWithLessThanOrEqualToGivenGoal(int nums[],int k){
        int left=0;
        int right=0;
        int count=0;
        // key and its freq in WINDOW
        HashMap<Integer,Integer> map=new HashMap<>();
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                int val=map.get(nums[left]);
                map.put(nums[left],val-1);
                if(val-1==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count+=(right-left);
            right++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numOfSubarraysWithLessThanOrEqualToGivenGoal(nums,k)-numOfSubarraysWithLessThanOrEqualToGivenGoal(nums,k-1);
    }
}