class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // this is actually easy
        // optimal->o(2*k)
        // hume actually max sum of a circular slidng window find karna hai
        // isliye liye hum 0 to k-1 wali window se start karte hai
        // aur fir window ko left karte jaate hai
        int left=0;
        int right=0;
        int sum=0;
        int max=0;
        // move right to k-1
        for(right=0;right<k;right++){
            sum+=cardPoints[right];
        }
        // edge case
        if(k==cardPoints.length){
            return sum;
        }
        // upaar wala loop complete hone par right=k(invalid condi jisse loop exit ho raha tha) ho raha tha
        // jiski wajah se galat ans aa raha tha ---> IMP
        right=k-1; //--> IMP
        max=sum;
        for(int i=0;i<k;i++){
            // welcome new element
            left=((left-1+cardPoints.length)%cardPoints.length);
            sum+=cardPoints[left];
            // remove old element
            sum-=cardPoints[right];
            right=((right-1+cardPoints.length)%cardPoints.length);
            max=Math.max(sum,max);
        }
        return max;
    }
}