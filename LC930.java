class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Better solution same as Subarray Sum Equals K
        HashMap<Integer,Integer> map=new HashMap<>();
        // dont forget this
        map.put(0,1);
        int currSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(map.containsKey(currSum-goal)){
                count+=map.get(currSum-goal);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
class Solution {
    // OPTIMAL -> O(2*2n) -> 2 times func call and 2n is in worst case 
    // SC->o(1)
    // yaha pe direct 2 pointer apprioach apply nhi ho raha because hume 
    // trim karte time smajh nhi aa raha ki left move kare ya right
    // because valid cases miss ho jaa rahe hai
    // so what we do is 
    // hum ne func banaya hai jo hume num of subarrays with sum<=goal return karta hai
    // but hume toh equal to goal wale cases chaiye 
    // toh iske liye hum func(goal)-func(goal-1) ke liye call karte hai
    // samjhe ?? first func call mai hume < goal wale cases unwanted hai
    // uske subtract karne ke liye second call karte hai jisme <=(goal-1) wale unwanted remove
    // ho jaate hai and we get the ans
    int numOfSubarrayWithLessThanOrEqualToGoal(int nums[],int goal){
        int left=0;
        int right=0;
        int count=0;
        int currSum=0;
        while(right<nums.length){
            currSum+=nums[right];
            while(left<nums.length && currSum>goal){
                currSum-=nums[left];
                left++;
            }
            count+=(right-left+1);
            right++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0){
            return numOfSubarrayWithLessThanOrEqualToGoal(nums,goal);
        }
        return numOfSubarrayWithLessThanOrEqualToGoal(nums,goal)-numOfSubarrayWithLessThanOrEqualToGoal(nums,goal-1);
    }
}