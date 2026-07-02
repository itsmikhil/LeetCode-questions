class Solution {
    class pair{
        int node,wt;
        pair(int node,int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // Prims Algo
        // Intuition:- it is nothing but GREEDY algo
        // Greedily pick the minimum-weight edge that connects
        // the current MST to an unvisited node.
        
        // IMP NOTE:-
        // here we mark them vis when we pop then
        // unlike other graph algos where we mark vis when we put it in queue
        
        // Approach:-
        // READ IMP NOTE ABOVE
        // put the src node
        // put its adj nodes inside q
        // in next turn then we remove node with min wt
        // then again the same cycle repeats
        
        // if we want to return selected edges also then we store parent also in pair class
        // and we put it inside ans AL when we are marking them vis that is while removing
        // them from queue
        
        // TC:
        // 1. Build adjacency list -> O(E)
        // 2. Traverse adjacency list -> O(E)
        // 3. Priority Queue:
        //    - Every edge is inserted at most once -> O(E) offers
        //    - Every inserted edge is removed once -> O(E) polls
        //    - PQ size can grow up to O(E), so each operation costs O(log E)
        //    => PQ cost = O(E log E)
        //
        // Overall TC = O(E log E)
        //
        // SC:
        // Adjacency List = O(E)
        // Visited Array = O(V)
        // Priority Queue = O(E)
        // Overall SC = O(E + V)
        
        
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new pair(v,wt));
            adj.get(v).add(new pair(u,wt));
        }
        PriorityQueue<pair> q=new PriorityQueue<>((a,b)->a.wt-b.wt);
        boolean vis[]=new boolean[V];
        int sum=0;
        q.offer(new pair(0,0));
        while(!q.isEmpty()){
            pair temp=q.poll();
            
            if(vis[temp.node]==true) continue;
            
            vis[temp.node]=true;
            sum+=temp.wt;
            
            for(pair el:adj.get(temp.node)){
                if(vis[el.node]==false){
                    q.offer(new pair(el.node,el.wt));
                }
            }
        }
        return sum;
    }
}
