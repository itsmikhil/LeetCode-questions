class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // optimal
        // agar mai 2 els ko fix kardu 
        // aur baaki do ko 2 pointer approach se dhund lu toh 
        // bass wahi hai

        // tc:n3 -> 2 forloops and one while loop
        // sc: constant

        // sort karna mat bhulana
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // agar prev element se same hai toh kyu pura repeat karu
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                // agar prev element se same hai toh kyu pura repeat karu
                // fixed index wale elements ke liye peeche ka check akro -> i,j
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                // i & j fixed by above 2 loops
                // k and l are our 2 pointer 
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        // note pehle ek baar increment kardo
                        // aur check ko ki agar woh peeche wale se same hai toh phir
                        // phir se quadra ban jayega aur duplicates store ho jayenge
                        // iss baar humare pass hashset bhi nhi hai duplicates se bachne ke liye
                        // isliye khud he handle karni padegi situation
                        List<Integer> quadra=new ArrayList<>();
                        // already sorted hoga because array sorted
                        quadra.add(nums[i]);
                        quadra.add(nums[j]);
                        quadra.add(nums[k]);
                        quadra.add(nums[l]);
                        ans.add(quadra);
                        k++;
                        l--;
                        while(k>0 && k<nums.length && nums[k]==nums[k-1]) k++;
                        while(l>=0 && l<nums.length-1 && nums[l]==nums[l+1]) l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // optimal
        // agar mai 2 els ko fix kardu 
        // aur baaki do ko 2 pointer approach se dhund lu toh 
        // bass wahi hai

        // tc:n3 -> 2 forloops and one while loop
        // sc: constant

        // sort karna mat bhulana
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            // agar prev element se same hai toh kyu pura repeat karu
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                // agar prev element se same hai toh kyu pura repeat karu
                // fixed index wale elements ke liye peeche ka check akro -> i,j
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                // i & j fixed by above 2 loops
                // k and l are our 2 pointer 
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        // note pehle ek baar increment kardo
                        // aur check ko ki agar woh peeche wale se same hai toh phir
                        // phir se quadra ban jayega aur duplicates store ho jayenge
                        // iss baar humare pass hashset bhi nhi hai duplicates se bachne ke liye
                        // isliye khud he handle karni padegi situation
                        List<Integer> quadra=new ArrayList<>();
                        // already sorted hoga because array sorted
                        quadra.add(nums[i]);
                        quadra.add(nums[j]);
                        quadra.add(nums[k]);
                        quadra.add(nums[l]);
                        ans.add(quadra);
                        k++;
                        l--;
                        while(k>0 && k<nums.length && nums[k]==nums[k-1]) k++;
                        while(l>=0 && l<nums.length-1 && nums[l]==nums[l+1]) l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return ans;
    }
}
