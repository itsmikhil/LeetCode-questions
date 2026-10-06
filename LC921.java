class Solution {
    public int minAddToMakeValid(String str) {
        // easy
        // jitne bach jayenge stack mai end mai
        // utne he new chars add kar ne padenge to make it complete
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if( curr=='('){
                s.push(curr);
            }else if(!s.isEmpty() && curr==')' && s.peek()=='('){
                s.pop();
            }else{
                s.push(curr);
            }
        }
        return s.size();
    }
}