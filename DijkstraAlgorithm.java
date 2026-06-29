class Solution {
    // Dijkstra Algo
    // tc:- ElogV
    // Slower than Topological Sort (O(V + E)), but Topological Sort works only for DAGs.
    // but Dijkstra works for all types of graph be it cyclic or acyclic
    // BUT THEY SHOULD HAVE POSITIVE EDGES ONLY
    
    
    class pair{
        int node,dis;
        pair(int node,int dis){
            this.node=node;
            this.dis=dis;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
       ArrayList<ArrayList<pair>> adj=new ArrayList<>();
       
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       
    //   Note Syntax for PRIORITY QUEUE
    // Node with smallest dis is selected first
    // Min-Heap: Node with the smallest distance is processed first.
       PriorityQueue<pair> q=new PriorityQueue<>((x,y)->x.dis-y.dis);
       int dis[]=new int[V];
    // this parent array will be used when we need to print path -> future question
       int parent[]=new int[V];
    //   imp initialisation
       Arrays.fill(parent,-1);
       Arrays.fill(dis,Integer.MAX_VALUE);
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           int distance=edges[i][2];
           adj.get(u).add(new pair(v,distance));
           adj.get(v).add(new pair(u,distance));
       }
       dis[src]=0;
       parent[src]=-1;
       q.offer(new pair(src,0));
       while(!q.isEmpty()){
           pair temp=q.poll();
           for(pair el:adj.get(temp.node)){
               if(dis[temp.node]+el.dis<dis[el.node]){
                   dis[el.node]=dis[temp.node]+el.dis;
                   q.offer(new pair(el.node,dis[el.node]));
                   parent[el.node]=temp.node;
               }
           }
       }
       for(int i=0;i<V;i++){
           if(dis[i]==Integer.MAX_VALUE){
               dis[i]=-1;
           }
       }
    //   CODE FOR PATH FINDING
    // while(parent[node] != -1){
    //     path.add(node);
    //     node = parent[node];
    // }
    // path.add(src);
    // Collections.reverse(path);
       return dis;
       
    }
}