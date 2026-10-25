class Solution {

    // normal dfs hai bus koyi bhi island boundary of matrix pe nhi hona chaiye

    // Mistake: If we return false immediately when a child DFS returns false,
    // the remaining connected cells may stay unvisited.
    //
    // Example:
    // 1 1 1
    // 0 0 1
    // 1 1 1
    //
    // Starting at (1,0), DFS detects a boundary cell and returns false.
    // If we return immediately, (1,1) remain unvisited.
    // Later, DFS starts from (1,1), but its left cell is already visited,
    // so it returns true and incorrectly increment the island count.
    //
    // Fix: Set closed = false, but continue visiting all neighbors.
    // so that entire chunk is marked visited as least si that it is not counted as ans 
    // in future traversal

    boolean dfs(int grid[][],boolean vis[][],int i,int j){
        vis[i][j]=true;

        boolean closed=true;
        if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
            closed=false;
        }
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        for(int k=0;k<dirs.length;k++){
            int nx=dirs[k][0]+i;
            int ny=dirs[k][1]+j;
            if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==0 && vis[nx][ny]==false ){
                boolean ans=dfs(grid,vis,nx,ny);
                if(ans==false){
                    closed=false;
                }
            }
        }
        return closed;
    }
    public int closedIsland(int[][] grid) {
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && vis[i][j]==false){
                    boolean ans=dfs(grid,vis,i,j);
                    if(ans){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}