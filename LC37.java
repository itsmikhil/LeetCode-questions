class Solution {
    // IMPPP
    boolean isSafe(char board[][],int i,int j,char digit){
        // row and col check
        for(int m=0;m<9;m++){
            if(board[m][j]==digit || board[i][m]==digit ){
                return false;
            }
        }

        // submatrix  ====> IMp Logic
        // for row=>(0,1,2)/3 = 0==> 0*3 ==> 0th row is the starting of a submatrix
        // for row=>(3,4,5)/3 = 1==> 1*3 ==> 3rd row is the starting of a submatrix
        // for row=>(6,7,8)/3 = 2==> 2*3 ==> 6th row is the starting of a submatrix
        int startRow=(i/3)*3; 
        // Same as above
        int startCol=(j/3)*3;
        for(int m=startRow;m<startRow+3;m++){
            for(int n=startCol;n<startCol+3;n++){
                if(board[m][n]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    boolean solve(char board[][]){
        // pehle mai i and j bhi pass kar raha tha solve func mai 
        // but issue loops start hone mai issue aa raha tha
        // isliye gpt and yt ke suggestion par i removed it
        // yt walo ne bhi aisse he kiya hai
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char digit='1';digit<='9';digit++){
                        if(isSafe(board,i,j,digit)){
                            board[i][j]=digit;

                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    // agar saare digits try kar liye fir bhi nhi place kar paa rahe
                    // matlab prev koyi placement mai issue hai 
                    // isliye return false

                    return false;

                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}