class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        for(int right=0;right<arr.length;right++){
            if(set.size()>k){
                set.remove(arr[left]);
                left++;
            }
            int curr=arr[right];
            if(set.contains(curr)){
                return true;
            }else{
                set.add(curr);
            }
        }
        return false;
    }
}