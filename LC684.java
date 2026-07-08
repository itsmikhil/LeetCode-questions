class Solution {

    // DFS to check if there is already a path from u to v
    boolean dfs(HashMap<Integer, ArrayList<Integer>> adj, int u, int v, boolean vis[]) {

        // Destination reached
        if (u == v) return true;

        // Mark current node as visited
        vis[u] = true;

        // Explore all neighbours of current node
        for (int neighbour : adj.get(u)) {

            // Visit only unvisited neighbours
            if (!vis[neighbour]) {

                // If destination is found in any path, return true
                if (dfs(adj, neighbour, v, vis)) {
                    return true;
                }
            }
        }

        // No path exists from u to v
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        // Adjacency list representing the graph built so far
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

        // Process each edge one by one
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Fresh visited array for every DFS
            boolean[] vis = new boolean[n + 1];

            /*
             * If both nodes already exist in the graph
             * and there is already a path between them,
             * adding this edge will create a cycle.
             */
            if (adj.containsKey(u) &&
                adj.containsKey(v) &&
                dfs(adj, u, v, vis)) {

                return edge;
            }

            // Add edge u -> v
            if (adj.containsKey(u)) {
                adj.get(u).add(v);
            } else {
                adj.put(u, new ArrayList<>());
                adj.get(u).add(v);
            }

            // Add edge v -> u (undirected graph)
            if (adj.containsKey(v)) {
                adj.get(v).add(u);
            } else {
                adj.put(v, new ArrayList<>());
                adj.get(v).add(u);
            }
        }

        // No redundant edge found
        return null;
    }
}
class Solution {

    // component wala check hum kisme karte hai ? DSU

    // TC:o(n*alpha)
    // Sc:o(n)

    class disjointSet{
        int size[];
        int parent[];
        disjointSet(int n){
            size=new int[n];
            parent=new int[n];
            for(int i=0;i<n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }
        int findUltParent(int u){
            // Path compression
            if(parent[u]==u){
                return u;
            }
            int parentOfU=findUltParent(parent[u]);
            parent[u]=parentOfU;
            return parentOfU;
        }
        boolean union(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);
            if(ultParentOfU==ultParentOfV) return false;
            if(size[ultParentOfU]>size[ultParentOfV]){
                parent[ultParentOfV]=ultParentOfU;
                size[ultParentOfU]=size[ultParentOfU]+size[ultParentOfV];
            }else{
                parent[ultParentOfU]=ultParentOfV;
                size[ultParentOfV]=size[ultParentOfV]+size[ultParentOfU];
            }
            return true;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        disjointSet ds=new disjointSet(n+1);
        for(int edge[]:edges){
            if(!ds.union(edge[0],edge[1])){
                return edge;
            }
        }
        return null;

    }
}