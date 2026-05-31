class Solution {
    public boolean canJump(int[] nums) {
        // Greedy idea:
        // Har index pe check karo ki hum kitna far reach kar sakte hain.
        // Agar current index hi unreachable hai, answer false.
        // Nahi to apni maximum reach ko update karte raho.
        // eg:-nums = [2,3,1,1,4]
        // i=0 max=(0,2+0)=>2
        // i=1 max=(2,3+1)=>4
        // i=2 max=(4,1+2)=>4
        // i=3 max=(4,1+3)=>4
        // i=4 max=(4,4+4)=>8
        // reached end => true

        // nums = [3,2,1,0,4]
        // i=0 max=(0,3+0)=>3
        // i=1 max=(3,2+1)=>3
        // i=2 max=(3,1+2)=>3
        // i=3 max=(3,0+3)=>3
        // i=4
        // i > max (4 > 3)
        // cannot reach index 4 => false
       

        int maxIndexWeCanReach=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIndexWeCanReach){
                return false;
            }
            maxIndexWeCanReach=Math.max(maxIndexWeCanReach,nums[i]+i);
        }
        return true;
    }
}