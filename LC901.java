// khud se banaya hai
class stock{
    int val;
    int span;
    public stock(int val,int span){
        this.val=val;
        this.span=span;
    }
}
// isme hum ek stack<stock> use karte hai 
// stock class stores val and iska span 
// note => agar curr el stack ke top ko pop kar sakta hai toh stack ke top ne jinko pehle pop kiya hai unko bhi pop kar sakta hai
// [100,80,60,70,60,75,85]
// stack<stock>
// [(100,1)]
// [(100,1),(80,1)]
// [(100,1),(80,1),(60,1)]
// [(100,1),(80,1),(70,2)] yaha 70 ka span = 60 ka span + 1(khud ka count)
// [(100,1),(80,1),(70,2),(60,1)] 
// [(100,1),(80,1),(75,4)] 75 ka span = 70.span + 60.span +1(khud ka count)
// [(100,1),(85,6)] 85 ks span = 80.span + 75.span +1(khud ka count)


class StockSpanner {
    Stack<stock> s;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        int spanOfCurrEl=0;
        while(!s.isEmpty() && s.peek().val<=price){
            spanOfCurrEl+=(s.pop().span);
        }
        // khud ka
        spanOfCurrEl++;
        s.push(new stock(price,spanOfCurrEl));
        return spanOfCurrEl;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */