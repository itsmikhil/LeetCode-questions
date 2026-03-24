class Solution {
    void func(List<List<Integer>> ans,List<Integer> temp,int candidates[],int curr,int sum,int target){
        if(curr>=candidates.length){
            return;
        }
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }else if(sum>target){
            return;
        }
        if(target-sum >= candidates[curr]){
            temp.add(candidates[curr]);
            func(ans,temp,candidates,curr,sum+candidates[curr],target);
            // remove karo only when add kiya hai
            // becuase i had kept remove outside if block thats why it was not working
            temp.remove(temp.size()-1);
        }
        func(ans,temp,candidates,curr+1,sum,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        func(ans,temp,candidates,0,0,target);
        return ans;
    }
}