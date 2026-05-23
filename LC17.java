class Solution {
    void helper(String digits,int curr,List<String> ans,String str){
        if(curr>=digits.length()){
            ans.add(new String(str));
            return;
        }
        // 2 se start hote hai characters isliye subtract by 2
        int digit=digits.charAt(curr)-'2';
        char ch=(char)('a'+(digit*3));
        // real nos 7 and 9 have 4 chars
        // but remember we have subtracter 2 from each digit
        // therefore here 7=>5 and  9=>7
        int len=(digit==5 || digit==7) ?4:3;
        // because real number 7 mai 4 chars hai 
        // isliye chracters find karne mai issue aata hai isliye real num 8 and onwards ke liye plus 1
        if(digit>=6){
            ch++;
        }
        for(int i=0;i<len;i++){
            helper(digits,curr+1,ans,str+ch);
            ch++;
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        helper(digits,0,ans,"");
        return ans;
    }
}