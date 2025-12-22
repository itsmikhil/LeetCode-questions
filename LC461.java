class Solution {
    public int hammingDistance(int x, int y) {
        // xor ka logic same as prev submission
        // isme we are eleminating string space hy iterating over bits
        // one line solution return Integer.bitCount(x ^ y); ----> does same thing
        int z=x^y;
        int count=0;
        while(z>0){
            int ld=z%2;
            if(ld==1){
                count++;
            }
            z/=2;
        }
        return count;
    }
}