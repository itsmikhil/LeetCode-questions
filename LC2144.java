class Solution {
    public int minimumCost(int[] cost) {
        // sort array
        Arrays.sort(cost);
        int count=0;
        int bill=0;
        for(int i=cost.length-1;i>=0;i--){
            count++;
            // every third chocolate free
            if(count%3==0){
                continue;
            }else{
                bill+=cost[i];
            }
        }
        return bill;
    }
}