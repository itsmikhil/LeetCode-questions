class Solution {
    // Brute Force
    // generating all strings and adding does who are valid
    boolean isValid(String s){
        int bal=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                bal++;
            }else{
                bal--;
            }
            if(bal<0){
                return false;
            }
        }
        return bal==0;
    }

    void recursiveFunction(int n,List<String> ans,StringBuilder a){
        if(n==0){
            if(isValid(a.toString())){
             ans.add(a.toString());
            }
            return ;
        }
        recursiveFunction(n-1,ans,new StringBuilder(a).append('('));
        recursiveFunction(n-1,ans,new StringBuilder(a).append(')'));
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder a =new StringBuilder();
         recursiveFunction(2*n,ans,a);
         return ans;
    }
}

class Solution {
    // dont use open-- instead of open-1 in recursion becuase its post increment and it sends current val
    // which leads to MLE
    void func(int open,int close,String curr,List<String> ans){
        if(open==0 && close==0){
            ans.add(curr);
            return;
        }
        if(open>0){
            func(open-1,close,curr+'(',ans);
        }
        if(close>open){
            func(open,close-1,curr+')',ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
         func(n,n,"",ans);
         return ans;
    }
}