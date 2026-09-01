class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        // same like agressive cows

        Arrays.sort(price);

        int low=1;

        int max=price[price.length-1];
        int min=price[0];
        int high=max-min;

        while(low<=high){
            int mid= low + (high-low)/2;

            // min is minDiff
            int numOfCandy=1;
            int prevIdx=0;
            for(int i=1;i<price.length;i++){
                if(price[i]-price[prevIdx]>=mid){
                    numOfCandy++;
                    prevIdx=i;
                }
            }

            if(numOfCandy<k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return high;

    }
}