class Solution {
    void helper(int nums[],List<List<Integer>> ans,List<Integer> list,int curr){
        // BEST IS TO DRAW THE REC TREE AND THEN WRITE CODE
        // MANTRA:- Duplicates elements shoudlnt fight for same position ===> Concept
        // first call mai list is empty woh [] add ho jata hai
        // here we are adding before checking if curr>nums.length because jo nums.length-1 idx ko contain karne wali
        // list hogi woh bhi add o jaye
        ans.add(new ArrayList<>(list));
        if(curr>=nums.length){
            return;
        }
        for(int i=curr;i<nums.length;i++){
            if(i>curr && nums[i-1]==nums[i]){
                continue;
            }
            list.add(nums[i]);
            helper(nums,ans,list,i+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // we sort so that duplicates ek saath aajaye aur hum unko same position ke liye fight karne se rokke
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(nums,ans,list,0);
        return ans;
    }
}