class Solution {
    // Brute Force
    // group is collection of stones that lie in same col or row via -via
    // agar ek group mai g stones hai toh remove hone ke baad bass 1 ke bachega
    // so assume there are group1Stones+group2Stones...
    // =g1+g2....
    // how many will be removed from a group=>
    // =(g1-1)+(g2-1)...
    // (g1+g2+g3...)-(1+1+1...)
    // (n)-(num of groups)
    // sab groups ka addition will give num of stones
    // because even if there is 1 stone it is also a group
    // toh kitne 1 bachenge woh number of groups ke jitne honge 
    // bass wahi kar rahe hai

    // TC:- o(n^2)
    // Sc:- o(n)
    void dfs(int[][] stones,int row,int col,boolean vis[]){
        for(int i=0;i<stones.length;i++){
            if(vis[i]==false){
                // Traverse every unvisited stone that shares the same
                // row or column. This explores one entire connected group.
                if(stones[i][0]==row || stones[i][1]==col){
                    vis[i]=true;
                    dfs(stones,stones[i][0],stones[i][1],vis);
                }
            }
        }
    }
    public int removeStones(int[][] stones) {
        int groups=0;
        boolean vis[]=new boolean[stones.length];
        for(int i=0;i<stones.length;i++){
            // New unvisited stone => start of another group
            if(vis[i]==false){
                vis[i]=true;
                dfs(stones,stones[i][0],stones[i][1],vis);
                groups++;
            }
        }

        return stones.length-groups;
        
    }
}

class Solution {
    // Better 
    // DSU

    // Idea:
    // Treat every stone as a node.
    // If two stones are in the same row or column, connect them.
    // After all connections, each connected component (group) can remove
    // all stones except one.
    // Answer = Total Stones - Number of Connected Components

    // TC: O(n² * α(n)) ≈ O(n²)
    // SC: O(n)
    class disjointSet{
        int parent[];
        int size[];
        disjointSet(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int findUltParent(int u){
            if(parent[u]==u) return u;
            parent[u]=findUltParent(parent[u]);
            return parent[u];
        }
        void unionBySize(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);
            if(ultParentOfV==ultParentOfU) return;
            if(size[ultParentOfU]>size[ultParentOfV]){
                parent[ultParentOfV]=ultParentOfU;
                size[ultParentOfU]=size[ultParentOfU]+size[ultParentOfV];
            }else{
                parent[ultParentOfU]=ultParentOfV;
                size[ultParentOfV]=size[ultParentOfV]+size[ultParentOfU];
            }
        }
    }
    public int removeStones(int[][] stones) {
        disjointSet ds=new disjointSet(stones.length);

        // grouping stones if they belong to same row or col
        for(int i=0;i<stones.length;i++){
            for(int j=i+1;j<stones.length;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1] ){
                    ds.unionBySize(i,j);
                }
            }
        }
        
        // finding num of groups
        int groups=0;
        for(int i=0;i<stones.length;i++){
            if(ds.parent[i]==i) groups++;
        }

        return stones.length-groups;
        
    }
}