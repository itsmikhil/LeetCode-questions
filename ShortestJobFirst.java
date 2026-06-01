class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        long waitingTime=0;
        long totalWaitingTime=0;
        for(int i=0;i<bt.length-1;i++){
            waitingTime+=bt[i];
            totalWaitingTime+=waitingTime;
        }
        long ans=(long)(totalWaitingTime/bt.length);
        if(ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }
}
