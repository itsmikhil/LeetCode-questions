
// entirely similar to "surrounded regions"

class Solution {
    void DFS(int i,int j,int grid[][],boolean vis[][]){
        // returning when illegal index or node is already visited or node is not 1
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || vis[i][j]==true || grid[i][j]!=1 ){
            return;
        }

        vis[i][j]=true;
        DFS(i-1,j,grid,vis);
        DFS(i+1,j,grid,vis);
        DFS(i,j+1,grid,vis);
        DFS(i,j-1,grid,vis);
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];

        // boundary 1 se dfs traversal start karo aur uske through jo bhi inside 1 accesible hai unhe visited mark 
        // karo
        // jo bach gaya woh connected nhi hai boundary 1 se means unhe hum count karke return karenge

        // calling for first and last col
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && vis[i][0]==false){
                DFS(i,0,grid,vis);
            }
            if(grid[i][m-1]==1 && vis[i][m-1]==false){
                DFS(i,m-1,grid,vis);
            }
        }

        // calling for first and last row
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && vis[0][j]==false){
                DFS(0,j,grid,vis);
            }
            if(grid[n-1][j]==1 && vis[n-1][j]==false){
                DFS(n-1,j,grid,vis);
            }
        }

        // if someone is left means it is not connected to any boundary 1
        // therefore it is counted and returned
        int count=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    count++;
                }
            }
        }
        return count;
    }
}