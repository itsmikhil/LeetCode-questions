class Solution {
    // simple dijstra
    // easy
    // isme we need to return ki humare path mai max waiting time kya tha
    // bass yahi khel hai
    class node{
        int cost;
        int row;
        int col;
        node(int cost,int row,int col){
            this.cost=cost;            
            this.row=row;
            this.col=col;
        }
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<node> q=new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        int dis[][]=new int[grid.length][grid[0].length];
        q.offer(new node(grid[0][0],0,0));
        vis[0][0]=true;
        dis[0][0]=grid[0][0];
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            node temp=q.poll();
            for(int i=0;i<dirs.length;i++){
                int nx=dirs[i][0]+temp.row;
                int ny=dirs[i][1]+temp.col;
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && vis[nx][ny]==false){
                    int newCost=Math.max(temp.cost,grid[nx][ny]);
                    vis[nx][ny]=true;
                    dis[nx][ny]=newCost;
                    q.offer(new node(newCost,nx,ny));
                }
            }
        }
        return dis[grid.length-1][grid[0].length-1];
    }
}