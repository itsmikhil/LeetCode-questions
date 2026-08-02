class Solution {
    public int mySqrt(int x) {
        // NOte this imp thing
        // high/end -> last possible answer (largest number whose square <= x)
        // low/start -> first impossible answer (smallest number whose square > x)
        // this is why we are returning end as ans
        if(x==1) return x;
        int start=1;
        int end=x;
        while(start<=end){
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;
            if(square<=x){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
}