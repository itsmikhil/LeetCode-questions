class Solution {
    public int largestRectangleArea(int[] heights) {
        // iska brute is array approach
        // this is optimal

        // understand this program as it is
        // it handles all testcases beautifully

        Stack<Integer> s=new Stack<>();
        // right smallest
        int right[]=new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            // note greater than equal to
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            // note store heights.length as right boundary for these
            if(s.isEmpty()){
                right[i]=heights.length;
            }else{
                right[i]=s.peek();
            }
            s.push(i);
        }

        s.clear();
        
        // left smallest
        int left[]=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            // note greater than equal to
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            // note store -1 as left boundary for these
            if(s.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=s.peek();
            }
            s.push(i);
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            // note the minus 1
            int area=((right[i]-left[i])-1)*heights[i];
            max=Math.max(area,max);
        }
        return max;

    }
}