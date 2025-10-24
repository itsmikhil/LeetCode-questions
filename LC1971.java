class Solution {
    void DFS(int node,List<List<Integer>> adj,boolean vis[]){
        vis[node]=true;
        for(int i=0;i<adj.get(node).size();i++){
            if(vis[adj.get(node).get(i)]!=true){
                DFS(adj.get(node).get(i),adj,vis);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // creating adj list from edges matrix
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        // src se dfs shuru karo agar uske baad destination visited hai matlab path exist
        // otherwise it doesnt
        DFS(source,adj,vis);
        return vis[destination]==true; 
    }
}