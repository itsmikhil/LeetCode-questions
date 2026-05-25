class Solution {
    boolean findWord(char[][] board,String word,int i,int j,int idx){
        // SAME LIKE "RATE IN A MAZE"
        // this recursion is nothing but DFS
        // iska badiya explanation Rat in a Maze mai likha hai
        // yaha sirf basic basic stuff likh rhaa hu

        // hum idx zero wale call pe idx 1 ke character ko find karte hai
        // isliye jab hum n-1 ke call pe hai matlab n-1 wala mil chuka hai
        // matlab pura word mil chuka hai
        if(idx==word.length()-1){
            return true;
        }

        // marking visitied warna woh apne he upar aata rahega baar baar
        char store=board[i][j];
        board[i][j]='.';
        // top
        if(i-1>=0 && board[i-1][j]==word.charAt(idx+1)){
            boolean ans=findWord(board,word,i-1,j,idx+1);
            if(ans){
                return true;
            }
        }
        // down
        if(i+1<board.length && board[i+1][j]==word.charAt(idx+1)){
            boolean ans=findWord(board,word,i+1,j,idx+1);
            if(ans){
                return true;
            }
        } 
        // left
        if(j-1>=0 && board[i][j-1]==word.charAt(idx+1)){
            boolean ans=findWord(board,word,i,j-1,idx+1);
            if(ans){
                return true;
            }
        } 
        // right
        if(j+1<board[0].length && board[i][j+1]==word.charAt(idx+1)){
            boolean ans=findWord(board,word,i,j+1,idx+1);
            if(ans){
                return true;
            }
        } 
        // un blocking
        board[i][j]=store;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans=findWord(board,word,i,j,0);
                    if(ans==true){
                        return ans;
                    }
                }
            }
        }
        return false;
    }
}