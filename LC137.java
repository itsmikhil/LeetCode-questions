class Solution {
    public int singleNumber(int[] nums) {
        // aasan he hai

        // bit manipulation
        // 32 bits hote hai binary String mai
        // ek ith bit kitni baar set hua hai nums ke saare els mai
        // wahi check kar rahe hai
        // aur setCount is not a multiple of 3
        // matlab woh bit humare missing Number mai bhi set hoga
        // bass yahi logic hai
        
        int result=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j] & (1<<i))!=0){
                    count++;
                }
            }
            if(count%3==1){
                result=(result | 1<<i);
            }
        }
        return result;
    }
}