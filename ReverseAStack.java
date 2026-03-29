class Solution {
    static void insertAtBottom(Stack<Integer> s,int val){
        if(s.isEmpty()){
            s.push(val);
            return;
        }
        int prev=s.pop();
        insertAtBottom(s,val);
        s.push(prev);
    }
    static void func(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int val=s.pop();
        func(s);
        insertAtBottom(s,val);
    }
    // saare elements ek ek karke nikalo and saare els ko pushATbottom
    // karo using recursion
    public static void reverseStack(Stack<Integer> s) {
       func(s);
    }
}
