class Solution {
    public int hammingWeight(int n) {
        // kuch nhi bass number of 1's count kiya
        int count=0;
        int rem=0;
        while(n>0){
            rem=n%2;
            if(rem==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
}