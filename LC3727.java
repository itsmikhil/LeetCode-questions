class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        // intution bade numbers ko addition grp mai daalo
        // aur chote numbers ko subtraction grp mai
        // my idea was ki array ko sort karo aur 2 pointers le lo
        // i=0 & j=nums.length-1
        // i walo ko subtraction grp mail daalo
        // and j waalo ko addition grp mai

        // but issue ye aa raha tha ki
        // we wanted sorting based on abolute value of els
        // but Arrays.sort doest do that
        // eg: nums=[-3,-2,-1,1,2,3] -> by normal Arrays.sort()
        // nums=[-1,1,-2,2,-3,3] -> what we wanted 
        // because square hoga toh neg & posi doesnt matter

        // Masterstroke
        // har el ka square karlo
        // fir sort karo
        
        // bas wahi kiya hai

        long ans=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);

        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(i==j){
                ans+=nums[i];
                i++;
                j--;
            }else{
                ans+=nums[j];
                ans-=nums[i];
                i++;
                j--;
            }
        }
        return ans;
    }
}