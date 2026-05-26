class Solution {
    public int[] finalPrices(int[] prices) {
        // just a variation of next smaller el
        // here we are only using n space complexity for stack
        Stack<Integer> s=new Stack<>();
        for(int i=prices.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()>prices[i]){
                s.pop();
            }
            int store=prices[i];
            // agar stack empty matlab no smaller el ahead 
            // isliye no discount
            if(!s.isEmpty()){
                prices[i]=prices[i]-s.peek();
            }
            s.push(store);
        }
        return prices;
    }
}