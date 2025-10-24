class Solution {

    void DFS(int i,int j,char board[][],boolean vis[][]){
        // returning when illegal index or node is already visited or node is not 'O'
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j]==true || board[i][j]!='O' ){
            return;
        }

        vis[i][j]=true;
        DFS(i-1,j,board,vis);
        DFS(i+1,j,board,vis);
        DFS(i,j+1,board,vis);
        DFS(i,j-1,board,vis);
    }

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];

        // boundary o se dfs traversal start karo aur uske through jo bhi inside o accesible hai unhe visited mark 
        // karo
        // jo bach gaya woh connected nhi hao boundary o se means unge hum x bana denge 

        // calling for first and last col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==false){
                DFS(i,0,board,vis);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==false){
                DFS(i,m-1,board,vis);
            }
        }

        // calling for first and last row
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==false){
                DFS(0,j,board,vis);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==false){
                DFS(n-1,j,board,vis);
            }
        }

        // if someone is left means it is not connected to any boundary o 
        // therefore it is chnaged to x
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==false){
                    board[i][j]='X';
                }
            }
        }
    }
}