class Solution {
    public static int xor(int n){
        // patterb of xor
        if(n%4==1){
            return 1;
        }else if(n%4==2){
            return n+1;
        }else if(n%4==3){
            return 0;
        }else{
            return n ; 
        }
    }
    public static int findXOR(int l, int r) {
        // we will find xor till right end
        // then we will find xor till left-1
        // then we will xor above both then the common terms that is from
        // 1 to left-1 gets cancel and we get xor from left to right
        return xor(r)^xor(l-1);
    }
}