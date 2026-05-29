class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // solution is exact same as prev question that is "Binary Subarrays With Sum"
        // jab jab even number aaye zero assume karo
        // jab jab odd number aaye one assume karo
        // better
        int oddCount=0; // instead of currSum in prev ques
        int count=0; 
        HashMap<Integer,Integer> map=new HashMap<>();
        // IMP -> i always forget this
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            oddCount+=(nums[i]%2);
            
            count+=map.getOrDefault(oddCount-k,0);

            map.put(oddCount,map.getOrDefault(oddCount,0)+1);
        }

        return count;


    }
}
class Solution {
    // solution is exact same as prev question that is "Binary Subarrays With Sum"
    // jab jab even number aaye zero assume karo
    // jab jab odd number aaye one assume karo
    // optimal
    int numOfSubarrayWithLessThanOrEqualToGoal(int nums[],int goal){
        int left=0;
        int right=0;
        int count=0;
        int oddCount=0;
        while(right<nums.length){
            oddCount+=(nums[right]%2);
            while(left<nums.length && oddCount>goal){
                oddCount-=(nums[left]%2);
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return numOfSubarrayWithLessThanOrEqualToGoal(nums,k)-numOfSubarrayWithLessThanOrEqualToGoal(nums,k-1);
    }
}