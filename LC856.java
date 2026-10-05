class Solution {
    public int scoreOfParentheses(String str) {
        // brute force
        // this hint from comment helped
        // We will use stack. And we compute something and push back to the stack.

        // representing ( with -1
        // so that we can use integer array

        // ()()-> 1+1
        // (()) -> (1)-> 2*1->2

        int count=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(curr=='('){
                s.push(-1);
            }else if(curr==')' && !s.isEmpty()){
                int sum=0;
                while(s.peek()!=-1){
                    int prevSum=s.pop();
                    sum+=prevSum;
                }
                // finally '(' found on top of stack
                s.pop();
                if(sum==0){
                    s.push(1);
                }else{
                    s.push(2*sum);
                }
            }
        }

        int finalAns=0;
        while(!s.isEmpty()){
            finalAns+=s.pop();
        }

        return finalAns;
    }
}

class Solution {
    public int scoreOfParentheses(String s) {
        // optimal
        // constant space

        // ((()))()
        // i=0 depth=1 score=0
        // i=1 depth=2 score=0
        // i=2 depth=3 score=0
        // i=3 depth=2 score=4  added 2^2 | because prev was (
        // i=4 depth=1 score=4  
        // i=5 depth=0 score=4  
        // i=6 depth=1 score=4  
        // i=7 depth=0 score=5  added 2^0 | because prev was (
        
        int depth=0;
        int score=0;

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='('){
                depth++;
            }else if(curr==')' && s.charAt(i-1)=='('){
                depth--;
                score+=(1<<depth);
            }else if(curr==')'){
                depth--;
            }

        }
        return score;
    }
}