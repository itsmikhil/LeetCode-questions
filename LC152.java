class Solution {
    public int maxProduct(int[] nums) {
        // dry run -> pg 138

        long pref=1;
        long suf=1;
        long max=Long.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            pref*=nums[i];
            suf*=nums[nums.length-1-i];

            max=Math.max(max,Math.max(pref,suf));
            
            if(pref==0) pref=1;
            if(suf==0) suf=1;
        }

        return (int)max;
    }
}