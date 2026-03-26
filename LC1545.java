// agar request for 4,4
// call 1=>3,4 middle element it would be 1
// agar request for 4,11(greater case)
// call 1:-3,5(greater case)
// call2:-2,3=>1(greater case)
// call 3:-1,1=>0(greater case)
// call 3  will return 0(base case)
// call 2 will retuen 1(invert)
// call 1 will return 0(invert)
// final ans=>1(invert)
class Solution {
    public char findKthBit(int n, int k) {
        if(k==1 && n==1){
            return '0';
        }
        int len=(int)Math.pow(2,n)-1;
        if(k==(len/2)+1){
            // mid always 1
            return '1';
        }else if(k<(len/2)+1){
            // ye ek level neeche bhi mil jayega
            return findKthBit(n-1,k);
        }else{
            // greater wale case mai corresponding bit ka reverse
            return findKthBit(n-1,len-k+1)=='0'?'1':'0';
        }

    }
}