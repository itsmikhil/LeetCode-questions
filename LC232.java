class MyQueue {
    // Brute force
    // here pop and peek is always O(n)
    // but we are asked to make it amortized O(1)
    // meaning jab jab possible ho tab tab o(1) aur kabhi kabhi O(n)
    // In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
        while(s1.size()!=1){
            s2.push(s1.pop());
        }
        int temp=s1.pop();
        while(s2.size()!=0){
            s1.push(s2.pop());
        }
        return temp;
    }
    
    public int peek() {
        while(s1.size()!=1){
            s2.push(s1.pop());
        }
        int temp=s1.peek();
        s2.push(s1.pop());
        while(s2.size()!=0){
            s1.push(s2.pop());
        }
        return temp;
    }
    
    public boolean empty() {
        return s1.size()==0;
    }
}


class MyQueue {
    // Optimal
    // make s1 as input stack
    // make s2 as output for poping and peeking operation 

    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
       s1.push(x);
    }
    
    public int pop() {
        // ek baar mai saara kuch reverse hoke pada rahega s2 mai 
        // wahi se baar baar pop karke bhej do
        // ek baar ki mehnat hai -> O(n)
        // uske baad O(1) ke maje
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        // same explantion as pop()
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        // dono empty hone chaiye
        return s1.size()==0 && s2.size()==0;
    }
}
