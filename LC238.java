class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we dont to use division operator
        // brute force -> n2 
        // har ek liye calc karo

        // optimal
        // agar mujhe mere left ka mul bata hai aur right ka pata hai
        // toh ans he mil jayega

        // bass wahi karenge prefix(left muli)
        // and sufix(right multi)
        // ye find kar lenge 
        // aur bass dono mul karke store kar denge ans mai
        // tc: o(3n)
        // sc:o(3n)

        // space optimization ans array mai he prefix store karlo 
        // then ek array kum use hoga
        int prefix[]=new int[nums.length];
        prefix[0]=1;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        int suffix[]=new int[nums.length];
        suffix[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        int ans[]=new int[nums.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}