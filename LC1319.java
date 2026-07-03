class Solution {
    // Simplest 
    // Theoritical approach 
    // NEXT approach will DISJOINT SET
    void dfs(ArrayList<ArrayList<Integer>> adj,boolean vis[],int m){
        vis[m]=true;
        for(int el:adj.get(m)){
            if(vis[el]==false){
                dfs(adj,vis,el);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        // for connection n nodes we need minimum of n-1 edges 
        if(connections.length<n-1){
            return -1;
        }
        // if above condition is passed means it is a possible case
        // now we find the number of components
        // if num of components =z
        // then we need z-1 edges to connect all components
        // bass wahi z-1 return karna hai 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[]=new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(adj,vis,i);
                components++;
            }
        }
        return components-1;
    }
}

class Solution {
    // optimal
    // Brute force wale he tareeke ko disjoint set ke saath kiya hai
    
    // TC:-
    // Initialization :- O(n)
    // Disjoint set single operation is alpha(a constant)
    // here DisjointSet does E ops so time taken :- E*alpha
    //Number of components finding:-  O(n)
    // Total:- o(n + E*alpha +n)
    //      :-O(n+E*alpha)
    //      :-O(n+E)
    //      :-O(n)
 

    class DisjointSet {
        int n;
        ArrayList<Integer> size;
        ArrayList<Integer> parent;

        DisjointSet(int n) {
            this.n = n;
            size = new ArrayList<>();
            parent = new ArrayList<>();
            // Note initialization
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        int findUltParent(int m){
            if(m==parent.get(m)) return m;

            int ultParent=findUltParent(parent.get(m));
            parent.set(m,ultParent);

            return parent.get(m);
        }

        void unionBySize(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);

            // when they are already connected
            if(ultParentOfU==ultParentOfV) return;
            // when UthComponent is bigger
            if(size.get(ultParentOfU)>size.get(ultParentOfV)){
                parent.set(ultParentOfV,ultParentOfU);
                size.set(ultParentOfU,size.get(ultParentOfU)+size.get(ultParentOfV));
            }else{
                // when either Vth component is bigger
                // or both are of SAME size
                parent.set(ultParentOfU,ultParentOfV);
                size.set(ultParentOfV,size.get(ultParentOfU)+size.get(ultParentOfV));
            }
        }

    }

    public int makeConnected(int n, int[][] connections) {
        // Impossible case
        if(connections.length<n-1){
            return -1;
        }
        
        // connect all nodes and edges
        // using DisjoinSet
        // which updates parent and size array in every operation
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            ds.unionBySize(connections[i][0],connections[i][1]);
        }
        int components=0;

        // for finding num of components we can find num of els who are their own parents
        // OR we can use if(ds.findUltParent(i) == i) instead of if(ds.parent.get(i)==i)
        // findUltParent is considered safer because just in case path compression has not happened
        // then we can make it happen and then check
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                components++;
            }
        }
        return components-1;
    }
}