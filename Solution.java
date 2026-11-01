class Solution {
    public int minGroups(int[][] intervals) {
        // same as min Number of platforms

        int start[]=new int[intervals.length];
        int end[]=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        int currNumOfPlatforms=0;
        int maxPlatforms=0;
        while(i<start.length && j<end.length){
            if(start[i]<=end[j]){
                currNumOfPlatforms++;
                maxPlatforms=Math.max(maxPlatforms,currNumOfPlatforms);
                i++;
            }else{
                currNumOfPlatforms--;
                j++;
            }
        }
        return maxPlatforms;
    }
}