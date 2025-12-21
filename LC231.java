class Solution {
    public boolean isPowerOfTwo(int n) {
        // new concept:-
        // for power of 2 only one - 1 is there in binary 
        // ie:- 16=10000
        // 8=1000
        // 32=10000
        // n bitwise and n-1 will always be zero
        // i.e 16(10000) and 15(1111)

        return n>0 && (n&n-1)==0?true:false;
    }
}