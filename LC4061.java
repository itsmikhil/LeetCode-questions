class Solution {
    // mistake
    // i converted source to 0 idx
    // but didnt covert target to zero idx while checking both to be equal
    class node{
        int x,y;
        node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int minQueenMoves(int[] source, int[] target) {
        if(source[0]==target[0] && source[1]==target[1]) return 0;
        boolean vis[][]=new boolean[8][8];

        Queue<node> q=new LinkedList<>();
        q.offer(new node(source[0]-1,source[1]-1));
        vis[source[0]-1][source[1]-1]=true;

        int dirs[][]={{-1,0},{0,-1},{0,1},{1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        int count=0;
        int size=0;
        while(!q.isEmpty()){
            size=q.size();
            count++;
            for(int k=0;k<size;k++){
                node temp=q.poll();
                int x=temp.x;
                int y=temp.y;
                for(int i=0;i<dirs.length;i++){
                    int nx=x;
                    int ny=y;
                    while(nx>=0 && nx<8 && ny>=0 && ny<8){
                        if(nx==target[0]-1 && ny==target[1]-1) return count;
                        if(vis[nx][ny]==false){
                            q.offer(new node(nx,ny));
                            vis[nx][ny]=true;
                        }
                        nx+=dirs[i][0];
                        ny+=dirs[i][1];
                    }
                }
            }
        }
        return -1;
        
    }
}