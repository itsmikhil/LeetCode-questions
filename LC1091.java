
// BFS

class Solution {
    class point{
        int x,y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        Queue<point> q=new LinkedList<>();
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        q.offer(new point(0,0));
        int count=0;
        int dis[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dis[i][j]=999;
            }
        }
        dis[0][0]=1;
        while(q.size()!=0){
            int n=q.size();
            for(int i=0;i<n;i++){
                point p=q.poll();
                for(int j=0;j<8;j++){
                    int nx=p.x+dirs[j][0];
                    int ny=p.y+dirs[j][1];
                    if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==0){
                        if(dis[nx][ny]>dis[p.x][p.y]+1){
                            dis[nx][ny]=dis[p.x][p.y]+1;
                            q.offer(new point(nx,ny));
                        }
                    }
                }
            }
        }
        return dis[grid.length-1][grid[0].length-1]!=999?dis[grid.length-1][grid[0].length-1]:-1;
    }
}