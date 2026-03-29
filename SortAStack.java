class Solution {
    
    static void asc(Stack<Integer> s,int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }else if(s.peek()>=val){
            s.push(val);
        }else{
            int prev=s.pop();
            asc(s,val);
            s.push(prev);
        }
    }
    public void sortStack(Stack<Integer> s1) {
        
        Stack<Integer> s2=new Stack<>();
        // i am taking another stack and i will transfer all els
        // from s1 to s2 by maintaining ascending order
        // then i will simply re transfer ell els from s2 to s1
        // so at the end i will get descending order in s1
        // we can do samething using 1 stack also but sab khichdi hoga
        // lekin space complexity reduce hoga
        
        while(!s1.isEmpty()){
            asc(s2,s1.pop());
        }
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        
    }
}