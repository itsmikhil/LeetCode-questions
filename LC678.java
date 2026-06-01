class Solution {
    public boolean checkValidString(String s) {
        // BRUTE FORCE can be RECURSION see FOOTER of this code
        // it gives TLE
        // OPTIMAL :- O(n)
        // we will maintain range because * kuch bhi bann sakta hai
        // for every star there can be 3 possibilities :-
        // +1(open brack),""(empty string),-1(close bracket)
        int minOpen=0;
        int maxOpen=0;
        for(int i=0;i<s.length();i++){
            // has case mai ++
            if(s.charAt(i)=='('){
                minOpen++;
                maxOpen++;
                // har case mai --
            }else if(s.charAt(i)==')'){
                minOpen--;
                maxOpen--;
                // min case mai --
                // max case mai ++
            }else if(s.charAt(i)=='*'){
                minOpen--;
                maxOpen++;
            }
            // agar min wal neg hi jaaye matlab usse close bracket toh nhi banayenge
            // sirf 2 posi bachegi 0 and +1 
            // so min that is +0 lenge
            // isliye usse wapas re factor kar denge
            if(minOpen<0) minOpen=0;
            // max wala bhi neg de raha hai matlab string mai gadbad
            // it has too many close brackets
            if(maxOpen<0)  return false;
        }
        // if minOpen stars from zero means its a valid string
        return minOpen==0;
    }
}
/*
void helper(String s,int idx,int openBrackets)
*/

// class Solution {
//     boolean helper(STring s,int idx,int openBracketCount){
//         if(count<0){
//             return false;
//         }
//         if(idx>s.length()){
//             if(count==0){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
//         if(s.charAt(i)=='('){
//             return helper(s,idx+1,count+1);
//         }else if(s.charAt(i)==')'){
//             return helper(s,idx+1,count-1);
//         }else if(s.charAt(i)=='*'){
//             return helper(s,idx+1,count+1) || helper(s,idx+1,count) || helper(s,idx+1,count-1)
//         }
//     }
//     public boolean checkValidString(String s) {
//             return helper(s,0,0){
//         }
//     }
// }