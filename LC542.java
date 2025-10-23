class Solution {

    class point{
        int x,y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        boolean visi[][]=new boolean[n][m];
        Queue<point> q=new LinkedList<>();
        int dis[][]=new int[n][m];

        // 0 khud ke liye 0 distance
        // and save these 0's in q
        // so that we can traverse its neighbours
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visi[i][j]=true;
                    q.offer(new point(i,j));
                    dis[i][j]=0;
                }
            }
        }
        
        //initially we start by traversing with 0's 
        // agar ek step mai kisi ke pass pahoch gaye toh distnace one 
        // add these visited to q again
        // abhi toh visi hai woh unke neigh ko visi karenge 
        // becuase hum second traversal mai uske pass pahoch rahe hai toh uska distance 2


        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                point temp=q.poll();
                int dirs[][]={{0,1},{1,0},{-1,0},{0,-1}};
                for(int dir[]:dirs){
                    int x=temp.x+dir[0];
                    int y=temp.y+dir[1];
                    if(x>=0 && x<n && y>=0 && y<m && visi[x][y]==false ){
                        visi[x][y]=true;
                        dis[x][y]=distance;
                        q.offer(new point(x,y));
                    }
                }
            }
            distance++;
        }
        return dis;

    }
}