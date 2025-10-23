class Solution {
    class point{
        public int x,y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        Queue<point> q = new LinkedList<>();
        boolean  visi[][]=new boolean[image.length][image[0].length];
        int initialColorOfStartingPoint=image[sr][sc];
        q.add(new point(sr,sc));
        image[sr][sc]=color;
        visi[sr][sc]=true;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){

                point temp=q.poll();
                // this dirs make the code shorter
                int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
                for (int[] d : dirs) {
                    int nx = temp.x + d[0];
                    int ny = temp.y + d[1];
                    if (nx>=0 && nx<n && ny>=0 && ny<m 
                        && !visi[nx][ny] && image[nx][ny]==initialColorOfStartingPoint) {
                        q.offer(new point(nx,ny));
                        visi[nx][ny] = true;
                        image[nx][ny] = color;
                    }
                }
            }
        }
        return image;
    }
}