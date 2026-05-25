class Solution {
    void pathFinder(int[][] maze,ArrayList<String> ans,int i,int j,String path){
        if(i==maze.length-1 && j==maze.length-1){
            ans.add(path);
            return;
        }
        // block it because warna hum aone he loop mai fass jayenge 
        // baar baar hum yahi aate rahenge
        // because ye curr block apne upaar wane ka down hai, apne left wale ka right hai
        // apne right wale ka left and apne neeche wale ka up hai
        // isliye hum isse mark kar dete hai taaki waapis yahi na aayaye
        maze[i][j]=0;
        // top
        if(i-1>=0 && maze[i-1][j]!=0) pathFinder(maze,ans,i-1,j,path+'U');
        // down
        if(i+1<maze.length && maze[i+1][j]!=0) pathFinder(maze,ans,i+1,j,path+'D');
        // left
        if(j-1>=0 && maze[i][j-1]!=0 && maze[i][j-1]!=-1) pathFinder(maze,ans,i,j-1,path+'L');
        // right
        if(j+1<maze.length && maze[i][j+1]!=0) pathFinder(maze,ans,i,j+1,path+'R');
        // more importnat then blocking is unblocking
        // becase a -> b,c
        // pehle a->b gaye aur ans nhi mila par 'a' toh block 
        // hogaya na bina a->c ko check kare
        // isliye we unblock the cells while back tracking
        // a->b is wrong doesnt mean a is wrong 
        // a->c can have correct ans
        maze[i][j]=1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans=new ArrayList<>();
        pathFinder(maze,ans,0,0,"");
        Collections.sort(ans);
        return ans;
    }
}