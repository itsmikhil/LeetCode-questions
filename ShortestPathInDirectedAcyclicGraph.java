class Solution {
    
    // TOPO Sort :- works only for Acyclic Directed graph
    // Since every node comes before its neighbours in topological order,
    // we can find shortest paths by processing nodes from left to right.
    
    // Dijkstra's does work for this particular question, but topo sort is preferred because 
    // it's a DAG. This topo sort method has a much better TC - O(V + E) compared to 
    // Dijkstra's O(E LogV). However, topo sort wouldn't work if there were cycles 
    // present in the graph. That's when you use Dijkstra's. If the graph has both a cycle 
    // and a negative weight in the cycle, both won't work! That's when you resort to Bellman Ford.
    
    // TC:- 2(V+E) 
    // (V+E)-> DFS of topological
    // (V+E)-> Stack traversal and dis updation
    class pair{
        int neigh,dis;
        pair(int neigh,int dis){
            this.neigh=neigh;
            this.dis=dis;
        }
    }
    
    void topoSort(ArrayList<ArrayList<pair>> adj,Stack<Integer> s,boolean vis[],int m){
        vis[m]=true;
        for(pair el:adj.get(m)){
            if(vis[el.neigh]==false){
                topoSort(adj,s,vis,el.neigh);
            }
        }
        s.push(m);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
       ArrayList<ArrayList<pair>> adj=new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int dis=edges[i][2];
            adj.get(u).add(new pair(v,dis));
       }
       boolean vis[]=new boolean[V];
       Stack<Integer> s=new Stack<>();
       for(int i=0;i<V;i++){
           if(vis[i]==false){
               topoSort(adj,s,vis,i);
           }
       }
       int dis[]=new int[V];
       Arrays.fill(dis,Integer.MAX_VALUE);
        // IMP   
       dis[0]=0;
       while(!s.isEmpty()){
           int temp=s.pop();
           if(dis[temp] != Integer.MAX_VALUE){
               for(pair el:adj.get(temp)){
                   if(el.dis+dis[temp]<dis[el.neigh]){
                       dis[el.neigh]=el.dis+dis[temp];
                   }
               }
           }
       }
       for(int i=0;i<V;i++){
           if(dis[i]==Integer.MAX_VALUE){
               dis[i]=-1;
           }
       }
       return dis;
    }
}