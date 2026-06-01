class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        int i=0;
        // left part(non intersecting)
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        // middle part(the intersecting one)
        int start=newInterval[0];
        int end=newInterval[1];
        while(i<intervals.length && intervals[i][0]<=end){
            start=Math.min(start,intervals[i][0]);
            end=Math.max(end,intervals[i][1]);
            i++;
        }
        list.add(new int[]{start,end});
        // right part (non intersecting)
        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        // note how are we converting AL to matrix
        return list.toArray(new int[list.size()][]);
    }
} 