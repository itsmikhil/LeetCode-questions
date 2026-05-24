class Solution {
    // See Notebook for explanation of algo
    // NOTE how we are storing solution as per question requirement
    void foundSolution(char board[][],List<List<String>> ans){
        List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            list.add(new String(board[i]));
        }
        ans.add(list);
    }
    boolean isSafe(char board[][],int i,int j){
        // left
        int dupRow=i;
        int dupCol=j;
        while(dupCol>=0){
            if(board[i][dupCol]=='Q') return false;
            dupCol--;
        }
        // upper diagonal
        dupRow=i;
        dupCol=j;
        while(dupCol>=0 && dupRow>=0){
            if(board[dupRow][dupCol]=='Q') return false;
            dupCol--;
            dupRow--;
        }
        // lower diagnol
        dupRow=i;
        dupCol=j;
        while(dupCol>=0 && dupRow<board.length){
            if(board[dupRow][dupCol]=='Q') return false;
            dupCol--;
            dupRow++;
        }
        return true;
    }
    void placeQueen(char board[][],List<List<String>> ans,int currCol){
        if(currCol==board.length){
            foundSolution(board,ans);
            return;
        }
        // we are placing queens COL wise ====> IMPORTANT
        for(int i=0;i<board.length;i++){
            if(isSafe(board,i,currCol)){
                board[i][currCol]='Q';
                placeQueen(board,ans,currCol+1);
                // re factor for next recursion 
                board[i][currCol]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char board[][]=new char[n][n];
        // initialize board
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        placeQueen(board,ans,0);
        return ans;
    }
}


class Solution {
    // See Notebook for explanation of algo
    // NOTE how we are storing solution as per question requirement
    void foundSolution(char board[][],List<List<String>> ans){
        List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            list.add(new String(board[i]));
        }
        ans.add(list);
    }
    void placeQueen(char board[][],List<List<String>> ans,int leftRow[],int topLeftDiagonal[],int bottomLeftDiagonal[],int currCol){
        if(currCol==board.length){
            foundSolution(board,ans);
            return;
        }
        // we are placing queens COL wise ====> IMPORTANT
        for(int i=0;i<board.length;i++){
            // WE are saving time by not tarversing to search if it safe
            if(leftRow[i]==0 && topLeftDiagonal[i+currCol]==0 && bottomLeftDiagonal[(board.length-1)+(currCol-i)]==0){
                leftRow[i]=1;
                topLeftDiagonal[i+currCol]=1;
                bottomLeftDiagonal[(board.length-1)+(currCol-i)]=1;
                board[i][currCol]='Q';
                placeQueen(board,ans,leftRow,topLeftDiagonal,bottomLeftDiagonal,currCol+1);
                // re factor for next recursion 
                board[i][currCol]='.';
                leftRow[i]=0;
                topLeftDiagonal[i+currCol]=0;
                bottomLeftDiagonal[(board.length-1)+(currCol-i)]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        int leftRow[]=new int[n];
        int topLeftDiagonal[]=new int[2*n-1];
        int bottomLeftDiagonal[]=new int[2*n-1];
        char board[][]=new char[n][n];
        // initialize board
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        placeQueen(board,ans,leftRow,topLeftDiagonal,bottomLeftDiagonal,0);
        return ans;
    }
}