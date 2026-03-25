// brute force
class Solution {
    // i was practicing recursion that why i used it 
    // similar solution using iteration also possible
    StringBuilder func(StringBuilder str,int curr,int n){
        if(curr>=n){
            return str;
        }
        // so that z ka next alphabet a aaye
        str.append((char)((((str.charAt(curr)-'a')+1)%26)+'a'));
        func(str,curr+1,n);
        return str;
    }
    public char kthCharacter(int k) {
        StringBuilder str=new StringBuilder("a");
        while(k>=str.length()){
            str=func(str,0,str.length());
        }
        return str.charAt(k-1);
    }
}