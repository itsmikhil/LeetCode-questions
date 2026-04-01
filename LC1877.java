class Solution {
    public int minPairSum(int[] nums) {
        // ek number sirf he he pair mai aa sakta hai
        // humare pass bohot saare cases hai jisme hum pairing kar sakte hai hai sabke max pair sum hota hai
        // hume sab cases mai se sabse min (max pair sum) jo hai woh hume return karna hai
        // isliye hum array ko sort karte hai shuru wale aur last wale ki paiaring karte jaate hai
        // for [3,5,2,3]=>why cant be pair 3,2 so that sum is 5
        // becuase iss case he sabhi pair mai se max dekhna hota hai toh 
        // saare pairs =>(2,3)(5,3)==>max sum toh 8 hogaya
        // isliye sorting wale se he sahi ans aata hai
        Arrays.sort(nums);
         int i=0;
         int j=nums.length-1;
         int max=0;
         while(i<j){
            max=Math.max(max,nums[i]+nums[j]);
            i++;
            j--;
         }
        return max;
    }
}