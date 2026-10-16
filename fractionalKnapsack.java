class Solution {
    class pair{
        int wt,val;
        double ratio;
        pair(int val,int wt,double ratio){
            this.val=val;
            this.wt=wt;
            this.ratio=ratio;
        }
    }
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        pair arr[]=new pair[val.length];
        
        for(int i=0;i<arr.length;i++){
            arr[i]=new pair(val[i],wt[i],(1.0*val[i])/wt[i]);
        }
        
        Arrays.sort(arr, (a, b) -> Double.compare(b.ratio, a.ratio));
        
        double ans=0;
        for(int i=0;i<arr.length;i++){
            if(capacity>=arr[i].wt){
                ans+=arr[i].val;
                capacity-=arr[i].wt;
            }else{
                ans+=(arr[i].ratio*capacity);
                capacity=0;
                break;
            }
        }
        return ans;
    }
}