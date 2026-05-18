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


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // optimal
        // pichle mai hum set use karte the to avoid duplicates 
        // yaha pe hum usko eleiminate kar rahe hai
        // isliye we will use sorted array directly
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        // we will use 3 pointer approach
        // i->first
        // j->second (initially i+1)
        // k->third (initially nums.length-1)
        // if sum greater then k--
        // if sum is smaller then j++
        for(int i=0;i<nums.length;i++){
            // i wala element ko same rakehenge toh pichla wala case fir se same hoga
            // because j,k are dependent on i
            // teeno milke he sum dete hai
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else{
                    List<Integer> triplet=new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    ans.add(triplet);
                    // because agar galti se j aur k same el ke duplicate ke upaar rehe gaye toh duplicate triplet milega
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans; 
    }
}