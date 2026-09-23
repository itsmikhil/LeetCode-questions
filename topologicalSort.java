class Solution {

    // Topo Sort mein agar u -> v hai,
    // toh answer mein u pehle aayega v se
    
    // dfs mai bass stack add karo toh toposort ban jayega
    
    // aise he tension leke baitha tha 
    
    // tc: o(v+e) -> dfs
    
    void dfs(int currNode, boolean vis[], 
             ArrayList<ArrayList<Integer>> list, Stack<Integer> s) {

        if (vis[currNode] == true) return;

        vis[currNode] = true;

        for (int neigh : list.get(currNode)) {
            dfs(neigh, vis, list, s);
        }

        // Jab currNode ke saare neighbours ka DFS complete ho jaye,
        // tab currNode ko stack mein daal do.

        // Jiska DFS pehle finish hota hai, usko pehle stack mein daalenge.
        // Stack se pop karne par order reverse ho jayega,
        // isliye woh node answer mein baad mein aayega.

        s.add(currNode);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        Stack<Integer> s = new Stack<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // Adjacency List bana rahe hain
        for (int i = 0; i < V; i++) {
            list.add(new ArrayList<>());
        }

        // u -> v edge hai, toh u ki list mein v daalenge
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            list.get(u).add(v);
        }

        boolean vis[] = new boolean[V];

        // Har node se DFS chala rahe hain
        // kyunki graph disconnected bhi ho sakta hai
        for (int i = 0; i < V; i++) {
            dfs(i, vis, list, s);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        // Stack ko pop karenge, isse DFS finishing order reverse ho jayega.
        // Jo node sabse pehle finish hui thi,
        // woh answer mein sabse last mein aayegi.
        //
        // Exactly yahi chahiye:
        // u -> v  =>  u answer mein v se pehle aaye.
        while (!s.isEmpty()) {
            ans.add(s.pop());
        }

        return ans;
    }
}

class Solution {
    
    // ONLY VALID FOR DAG
    
    // toposort ko agar bfs ke saath kare toh kahns algo
    
    // here we keep track of numberOfIncomingEdgesForEachNode
    // S1: if somone has zero incmoing edges matlab usse dusro pe edge jaati hai
    // add it in queue
    // s2: while doing bfs jo bhi neigh ho popped node ka uske incmoingEdges ko decrement karo
    // agar zero ho jaaye toh usse bhi q mai daalo
    
    // bas yahi hai
    
    // tc: o(v+e)
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        Queue<Integer> q=new LinkedList<>();
        int incomingEdgesCount[]=new int[V];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            list.get(u).add(v);
            incomingEdgesCount[v]++;
        }
        boolean vis[]=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(incomingEdgesCount[i]==0){
                q.add(i);
                vis[i]=true;
                ans.add(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int currNode=q.poll();
            for(int neigh:list.get(currNode)){
                if(vis[neigh]==false){
                    incomingEdgesCount[neigh]--;
                    if(incomingEdgesCount[neigh]==0){
                        q.add(neigh);
                        vis[neigh]=true;
                        ans.add(neigh);
                    }
                }
            }
        }
        
        return ans;
        
    }
}