class Solution {
    // Same like 130. Surrounded Regions
    // DFS
    // SC optimization:- We can avoid use of vis array by replacing 1->0 
    void dfs(char[][] grid,boolean vis[][],int m, int n){
        vis[m][n]=true;
        int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<dirs.length;i++){
            int nx=m+dirs[i][0];
            int ny=n+dirs[i][1];
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]=='1' && vis[nx][ny]==false){
                dfs(grid,vis,nx,ny);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j]==false && grid[i][j]=='1'){
                    dfs(grid,vis,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}