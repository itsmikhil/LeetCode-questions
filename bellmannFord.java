class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        
        // Bellman-Ford Algorithm
        // Single Source Shortest Path (SSSP)

        // Intuition:
        // Keep relaxing every edge. for V-1 times -> Note
        // Every relaxation tries to improve the shortest distance.
        // After enough relaxations, all shortest paths become fixed.

        // Why V-1 relaxations?
        // A shortest path can contain at most (V-1) edges.
        // So after relaxing all edges (V-1) times,
        // every shortest path must have been considered.

        // Negative Cycle Detection: 
        // agar v-1 relaxation cycles ke baad bhi agar fir se koyi dis change
        // hota hai matlab negative edge cycle hai
        // Relax all edges one more time.
        // If any distance still decreases,
        // then a reachable negative-weight cycle exists.

        // Important:
        // if (dist[u] != 1e9)
        // Prevents relaxing from an unreachable node.
        // Also avoids incorrect calculations like 1e9 + (-5). -> it becomes 9999999995
        // which is less then 1e9 but it shouldnt happen so

        // Works for:
        // ✔ Directed graphs
        // ✔ Undirected graphs (without negative edges)
        // ✔ Positive edge weights
        // ✔ Negative edge weights
        // ✔ Graphs with cycles

        // Doesn't work for:
        // ✘ Reachable negative-weight cycles
        // (can detect them, but shortest paths are undefined)

        // Comparison:
        // Dijkstra -> Faster (O(E log V)) but cannot handle negative edges.
        // Bellman-Ford -> Slower but supports negative edge weights.

        // Time Complexity:
        // O(V * E)

        // Auxiliary Space:
        // O(V)
        
        ArrayList<Integer> dis=new ArrayList<>();
        // preparing dis list
        for(int i=0;i<V;i++){
            dis.add((int)1e9);
        }
        dis.set(src,0);
        
        // relaxing v-1 times
        for(int i=0;i<V-1;i++){
            
            for(int edge[]:edges){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if (dis.get(u) != (int)1e9) {
                    dis.set(v, Math.min(dis.get(v), dis.get(u) + wt));
                }
            }
        }
        
        // negative cycle dectection
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dis.get(u) != (int)1e9 && dis.get(u) + wt < dis.get(v)) {
                // Negative cycle found
                ArrayList<Integer> ans=new ArrayList<>();
                ans.add(-1);
                return ans;
            }
        }
        
        // set infinity to 1e8 if unreachable -> as per question demand
        for(int i=0;i<V;i++){
            if(dis.get(i)==(int)1e9){
                dis.set(i,(int)1e8);
            }
        }
        
        return dis;
        
    }
}
