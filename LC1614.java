class Solution {
    public int maxDepth(String s) {
        int max=0;
        int currDept=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                currDept++;
                max=max<currDept?currDept:max;
            }else if(s.charAt(i)==')'){
                currDept--;
            }
        }
        return max;
    }
}