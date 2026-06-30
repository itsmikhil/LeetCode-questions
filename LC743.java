class Solution {
    // Normal dijstra he hai bass end mai maxTime taken to reach return kardo
    // ya phir koyi node unreachable hai toh -1 return 

    // here we have used PQ because of non uniform edges

    // TC:- (V+E) + (E logV) + V => E logV
    // Sc:- (V+E)
    class pair{
        int node,dis;
        pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int el[]:times){
            int u=el[0];
            int v=el[1];
            int dis=el[2];
            adj.get(u).add(new pair(v,dis));
        }
        int dis[]=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.dis-b.dis);
        q.offer(new pair(k,0));
        dis[k]=0;
        while(!q.isEmpty()){
            pair temp=q.poll();
            for(pair el:adj.get(temp.node)){
                if(dis[temp.node]+el.dis<dis[el.node]){
                    dis[el.node]=dis[temp.node]+el.dis;
                    q.offer(new pair(el.node,dis[el.node]));
                }
            }
        }
        int max=0;
        for(int i=1;i<dis.length;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(dis[i],max);
        }
        return max;
    }
}