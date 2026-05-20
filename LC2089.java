class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // no need of sorting or binary seacrh 
        // just count the num of els smaller then target and also num of occ of our target
        // it can be done in O(n)
        // then why waste nlogn in sorting
        int smaller=0; // to predict starting index in sorted array
        int occ=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                occ++;
            }else if(nums[i]<target){
                smaller++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<occ;i++){
            ans.add(i+smaller);
        }
        return ans;
    }

}