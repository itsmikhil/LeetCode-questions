class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // similar to N meetings in a room

        // Greedy idea:
        // Always pick the interval that ends earliest because
        // it leaves maximum space for upcoming intervals.

        // NOTE :- Inthis problem 1,2 and 2,3 are not overlapping

        // sort the array based on finish time ---> IMP
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int maxEndTime= intervals[0][1];
        // pehle event to possible assume kar liya
        int count=1;
        // kitne intervals non overlapping intervals hai woh find karlo
        // fir baaki unhe total se subtract kar denge toh overalapping mil jayenge
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=maxEndTime){
                count++;
                maxEndTime=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}