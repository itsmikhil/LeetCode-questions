class Solution {
    public int countNegatives(int[][] grid) {
        // staircase approach 
        // agar curr elment neg and toh uske neeche wale pakka neg honge becuase col wise also sorted
        // isliye agat neg wala case mile toh neeche wale elements ko add karo left wale row mai jao
        // agar curr el neg nhi hai toh neeche wale col mai try karo
        int i=0;
        int j=grid[0].length-1;
        int count=0;
        while(i<grid.length && j>=0){
            if(grid[i][j]<0){
                count+=(grid.length-i);
                j--;
            }else{
                i++;
            }
        }
        return count;
    }
}