class Solution {

    // For dijstra(BFS):- 
    // agar Priority queueu(like this question) used then First time you pop the destination = optimal answer.
    // if normal queue(like in prev question) used :- First time you discover the destination = shortest path.

    // Important
    // TC:- E logV
    // number of edges in grid:- n*m*4 because edges in 4 direction
    // number of vertices:- n*m
    // TC:- n*m*4 log(n*m)
    class point{
        int x,y,diff;
        point(int x,int y,int diff){
            this.x=x;
            this.y=y;
            this.diff=diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int diff[][]=new int[heights.length][heights[0].length];
        for(int i=0;i<diff.length;i++){
            Arrays.fill(diff[i],Integer.MAX_VALUE);
        }
        PriorityQueue<point> q=new PriorityQueue<>((a,b)->a.diff-b.diff);
        diff[0][0]=0;
        q.offer(new point(0,0,0));
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            point temp=q.poll();
            for(int i=0;i<dirs.length;i++){
                int nx=temp.x+dirs[i][0];
                int ny=temp.y+dirs[i][1];
                // here PQ is used means first time we pop the destination means we have got optimal ans
                if(temp.x==heights.length-1 && temp.y==heights[0].length-1 ) return temp.diff;
                if(nx>=0 && nx<heights.length && ny>=0 && ny<heights[0].length ){
                    int difference=Math.abs(heights[temp.x][temp.y]-heights[nx][ny]);
                    int maxDiff=Math.max(difference,temp.diff);
                    if(maxDiff < diff[nx][ny]){
                        // BFS mai pehli baar he sabse shortest mai pohoch jaate hai
                        diff[nx][ny]=maxDiff;
                        q.offer(new point(nx,ny,maxDiff));
                    }
                }
            }
        }
        return diff[heights.length-1][heights[0].length-1 ];
    }
}