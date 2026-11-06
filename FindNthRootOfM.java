public class Solution {
    public static int NthRoot(int n, int m) {
        // Binary search
        int start=1;
        int end=m;
        while(start<=end){
            int mid=(start+end)/2;
            
            int val=(int)(Math.pow(mid,n));
            if(val==m){
                return mid;
            }else if(val<m){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
