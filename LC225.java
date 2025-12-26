class MyStack {
    // using 2 queue's
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

class MyStack {
    // using 1 queue
    Queue<Integer> q1;
    public MyStack() {
        q1=new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        int n=q1.size()-1;
        for(int i=0;i<n;i++){
            q1.offer(q1.poll());
        }
        return q1.poll();
    }
    
    public int top() {
        int n=q1.size()-1;
        for(int i=0;i<n;i++){
            q1.offer(q1.poll());
        }
        int temp=q1.peek();
        q1.offer(q1.poll());
        return temp;
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}
