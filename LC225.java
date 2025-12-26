class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        while(q1.size()!=1){
            q2.offer(q1.poll());
        }
        int temp=q1.poll();
        while(q2.size()!=0){
            q1.offer(q2.poll());
        }
        return temp;
    }
    
    public int top() {
        int temp=pop();
        q1.offer(temp);
        return temp;
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}