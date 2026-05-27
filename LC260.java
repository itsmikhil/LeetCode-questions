class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // same numbers cancel each other because x^x = 0
        // so finally xor will contain only unique1 ^ unique2
        for(int i=0;i<nums.length;i++){
            xor ^= nums[i];
        }

        // finding rightmost set bit
        // this bit will definitely be different in both unique numbers
        // example:
        // unique numbers = 3(011) and 5(101)
        // xor = 110
        // rightmost set bit = 010
        int rightMostSetBit = xor & (-xor);

        // long taken to avoid overflow issues in bit operations
        // what if we need to do with -2^31 
        // by the time its duplicate comes we need to hold it
        // thats why we took LONG ====> IMP 
        long xor1 = 0;
        long xor2 = 0;
        // IMP LOGIC
        // divide numbers into 2 groups
        // one group having this bit set
        // other group not having this bit set
        // duplicate numbers will go in same group and cancel out
        // unique numbers will go in different groups
        for(int i=0;i<nums.length;i++){

            if((nums[i] & rightMostSetBit) != 0){
                xor1 ^= nums[i];
            }
            else{
                xor2 ^= nums[i];
            }
        }

        return new int[]{(int)xor1,(int)xor2};
    }
}