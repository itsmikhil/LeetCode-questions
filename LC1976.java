class Solution {
    // Intuition:
    // We need to find not only the shortest distance from node 0 to node n-1,
    // but also how many different shortest paths exist.
    // Dijkstra's Algorithm gives the shortest distance efficiently.
    // Along with distance, we maintain a ways[] array where
    // ways[i] = number of shortest paths to reach node i.
    //
    // Approach:
    // 1. Build the adjacency list for the undirected weighted graph.
    // 2. Use Dijkstra's Algorithm with a Min Heap (PriorityQueue).
    // 3. Maintain:
    //      - dis[]  -> shortest distance to each node.
    //      - ways[] -> number of shortest paths to each node.
    // 4. While relaxing an edge:
    //      - If a shorter path is found:
    //            Update distance.
    //            Copy the number of ways from the current node.
    //      - If another path with the same shortest distance is found:
    //            Add the current node's ways to the destination's ways.
    // 5. Return ways[n-1] modulo 1e9+7.
    class pair{
        int node;
        long dis;
        pair(int node,long dis){
            this.node=node;
            this.dis=dis;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int el[]:roads){
            int u=el[0];
            int v=el[1];
            int dis=el[2];
            adj.get(u).add(new pair(v,dis));
            adj.get(v).add(new pair(u,dis));
        }
        long dis[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        // Normal comparator can overfloe thats why Long.compare
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->Long.compare(a.dis,b.dis));
        q.offer(new pair(0,0));
        dis[0]=0;
        ways[0]=1;
        while(!q.isEmpty()){
            pair temp=q.poll();

            if(temp.dis > dis[temp.node])continue;

            for(pair el:adj.get(temp.node)){
                if(dis[temp.node]+el.dis<dis[el.node]){
                    dis[el.node]=dis[temp.node]+el.dis;
                    ways[el.node]=ways[temp.node];
                    q.offer(new pair(el.node,dis[el.node]));
                }else if(dis[temp.node]+el.dis==dis[el.node]){
                    ways[el.node]=(ways[el.node]+ways[temp.node])%mod;
                }
            }
        }
        return ways[n-1];
    }
}