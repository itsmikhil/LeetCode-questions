class Solution {
    class point{
        public int x,y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<point> q=new LinkedList<>();
        int fresh=0;
        int rot=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    rot++;
                    q.offer(new point(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        if(rot==0){
            return -1;
        }
        boolean visi[][]=new boolean[grid.length][grid[0].length];
        int time=0;
        while(!q.isEmpty()){
            int k=q.size();
            int newRot=0;
            // Problem:
            // Suppose the last level of BFS contains rotten oranges but none of their neighbors are fresh.
            // You still increment time++.
            // That artificially adds an extra minute that didn’t really exist — because nothing changed in the grid during that “minute.”

// ✅ This is why your answer can be off by 1.

// see flood fill question ,see how it is made short similarly this can also be done
            for(int i=0;i<k;i++){
                point temp=q.poll();
                if(temp.x+1<n && grid[temp.x+1][temp.y]==1 && visi[temp.x+1][temp.y]==false){
                    q.offer(new point(temp.x+1,temp.y));
                    grid[temp.x+1][temp.y]=2;
                    visi[temp.x+1][temp.y]=true;
                    fresh--;
                    newRot=1;
                }
                if(temp.x-1>=0 && grid[temp.x-1][temp.y]==1 && visi[temp.x-1][temp.y]==false){
                    q.offer(new point(temp.x-1,temp.y));
                    grid[temp.x-1][temp.y]=2;
                    visi[temp.x-1][temp.y]=true;
                    fresh--;
                    newRot=1;
                }
                if(temp.y+1<m && grid[temp.x][temp.y+1]==1 && visi[temp.x][temp.y+1]==false ){
                    q.offer(new point(temp.x,temp.y+1));
                    grid[temp.x][temp.y+1]=2;
                    visi[temp.x][temp.y+1]=true;
                    fresh--;
                    newRot=1;
                }
                if(temp.y-1>=0 && grid[temp.x][temp.y-1]==1 && visi[temp.x][temp.y-1]==false){
                    q.offer(new point(temp.x,temp.y-1));
                    grid[temp.x][temp.y-1]=2;
                    visi[temp.x][temp.y-1]=true;
                    fresh--;
                    newRot=1;
                }
            }
            if(newRot==1){
                time++;
            }
        }
        return fresh==0?time:-1;
    }
}