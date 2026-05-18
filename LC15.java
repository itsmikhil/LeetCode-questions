class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // set becuase we want unique triplets
        HashSet<List<Integer>> ans=new HashSet<>();
        // outer loop selects first number
        for(int i=0;i<nums.length;i++){
            // we re initialize set for every new i
            // set only has numbers which are between i and j pointer 
            // aisa nhi karenge toh ho sakta hai woh i ya j wale el ko he third number ki tarah maan lega 
            // 4 1 2 -2
            // i      j
            // abhi hume -2 he chaiye but set mai sirf (1,2)=>beech wale els ho honge
            // aisa nhi karte toh woh fir se -2 ko ki j hai usko fir se le leta
            HashSet<Integer> set=new HashSet<>();
            // this loop selects second number
            for(int j=i+1;j<nums.length;j++){
                int third=-(nums[i]+nums[j]);
                if(set.contains(third)){
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(third);
                    // we sort and store triplets in set so that we get only unique triplets
                    Collections.sort(triplet);
                    ans.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> list=new ArrayList<>(ans);
        return list;
    }
}