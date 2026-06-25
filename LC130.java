class Solution {
    // Approach:
    // Any 'O' that is connected to a boundary 'O' (directly or indirectly)
    // can never be converted into 'X'.
    //
    // So, we start DFS from every boundary 'O' and mark all the connected 'O's.
    //
    // After the traversal is complete,
    // any remaining unvisited 'O' must be completely surrounded,
    // so we convert it to 'X'.

    // TC:- O(m+n){row anc col check }+O(m×n){DFS in worst}+O(m×n){final traversal}=O(m×n)
    void dfs(char[][] board,boolean vis[][],int m, int n){
        vis[m][n]=true;
        int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<dirs.length;i++){
            int nx=m+dirs[i][0];
            int ny=n+dirs[i][1];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && board[nx][ny]=='O' && vis[nx][ny]==false){
                dfs(board,vis,nx,ny);
            }
        }
    }
    public void solve(char[][] board) {
        boolean vis[][]=new boolean[board.length][board[0].length];
        // checking for boundary row 
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O' && vis[0][i]==false){
                dfs(board,vis,0,i);
            }
            if(board[board.length-1][i]=='O' && vis[board.length-1][i]==false){
                dfs(board,vis,board.length-1,i);
            }
        }
        // checking for boundary col 
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O' && vis[i][0]==false){
                dfs(board,vis,i,0);
            }
            if(board[i][board[0].length-1]=='O' && vis[i][board[0].length-1]==false){
                dfs(board,vis,i,board[0].length-1);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }

}