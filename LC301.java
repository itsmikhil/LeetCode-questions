class Solution {
    // take,notTake jaisa kuch lag raha hai
    // backtracking 
    // note sabse minimum number of removals -> lekin koyi limit nhi
    // examples dekh ke lagat hai ki sirf ek removal karna hai
    // but aisa nhi hai

    // given max 20 length of parenthesis
    // so tc: 2^20 ~ 10^6
    void helper(String s,HashSet<String> set,StringBuilder sb,int maxLength[],int idx,int count){
        
        if(idx==s.length()){
            if(count==0){

                // jitna bhi highest length ki possible ho sakti hai wahi chaiye
                // purani wale strings hata do
                if(sb.length()>maxLength[0]){
                    set.clear();
                    maxLength[0]=sb.length();
                }

                // aage jaake choti length wali valid string add nhi ho jaaye
                if(sb.length()==maxLength[0]){
                    set.add(sb.toString());
                }
                
            }

            return;
        }

        // count<0 matlab invalid
        if(count<0 || idx>s.length()){
            return;
        }

        // notTake
        // sirf bracket ke liye he notTake option hai
        // alphabet toh chaiye he
        if(s.charAt(idx)=='(' || s.charAt(idx)==')'){
            helper(s,set,sb,maxLength,idx+1,count);
        }

        // take
        sb.append(s.charAt(idx));
        if(s.charAt(idx)=='('){
            count++;
        }else if(s.charAt(idx)==')'){
            count--;
        }
        helper(s,set,sb,maxLength,idx+1,count);
        sb.deleteCharAt(sb.length()-1);

        return;

    }
    public List<String> removeInvalidParentheses(String s) {

        StringBuilder sb=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        int maxLength[]=new int[1];
        helper(s,set,sb,maxLength,0,0);

        List<String> ans=new ArrayList<>();
        for(String el:set){
            ans.add(el);
        }

        return ans;
    }
}