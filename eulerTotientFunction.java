class Solution {
    public int etf(int n) {
        int result=n;
        
        for(int p=2;p*p<=n;p++){
            
            if(n%p==0){
                result=result - (result/p);
                
                while(n%p==0){
                    n/=p;
                }
                
            }
            
        }
        
        if(n>1){
            result=result - (result/n);
        }
        return result;
    }
}