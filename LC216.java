class Solution {
    void makeCombinations(int reqListSize,int target,int currNum,List<List<Integer>> ans,List<Integer> list,int currSum){

        // valid case
        // sum==target and also listSize==reqListSize

        // remember to add list to new ArrayList<>() -> Remember
        if(currSum==target && list.size()==reqListSize){
            ans.add(new ArrayList<>(list));
            return;
        }

        // invalid cases

        // digits only allowed till 9
        if(currNum>9){
            return;
        }
        if(currSum>target){
            return;
        }

        if(list.size()>reqListSize){
            return;
        }
        
        // take
        list.add(currNum);
        makeCombinations(reqListSize,target,currNum+1,ans,list,currSum+currNum);
        list.remove(list.size()-1);

        // notTake
        makeCombinations(reqListSize,target,currNum+1,ans,list,currSum);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();

        makeCombinations(k,n,1,ans,list,0);

        return ans;
    }
}