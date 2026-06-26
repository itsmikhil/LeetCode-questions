class Solution {
    ArrayList<Integer> dfs( ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list,boolean vis[],int m){
        vis[m]=true;
        list.add(m);
        for(int el:adj.get(m)){
            if(vis[el]==false){
                dfs(adj,list,vis,el);
            }
        }
        return list;
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[]=new boolean[V];
        for(int i=0;i<adj.size();i++){
            if(vis[i]==false){
                ArrayList<Integer> list=dfs(adj,new ArrayList<>(),vis,i);
                ans.add(list);
            }
        }
        return ans;
    }
}