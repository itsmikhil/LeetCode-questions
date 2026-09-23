class Solution {
    class DSU{
        int n;
        ArrayList<Integer> parent,size;
        DSU(int n){
            parent=new ArrayList<>();
            size=new ArrayList<>();
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        int findUltParent(int u){
            if(u==parent.get(u)) return u;
            int ultParent=findUltParent(parent.get(u));
            parent.set(u,ultParent);
            return ultParent;
        }
        void unionBySize(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);
            if(ultParentOfU==ultParentOfV) return;
            
            int sizeOfUltParentOfU=size.get(ultParentOfU);
            int sizeOfUltParentOfV=size.get(ultParentOfV);
            
            if(sizeOfUltParentOfU>sizeOfUltParentOfU){
                parent.set(ultParentOfV,ultParentOfU);
                size.set(ultParentOfU,sizeOfUltParentOfU+sizeOfUltParentOfV);
            }else{
                parent.set(ultParentOfU,ultParentOfV);
                size.set(ultParentOfV,sizeOfUltParentOfU+sizeOfUltParentOfV);
            }
        }
    }
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        
        DSU dsu=new DSU(n);
        ArrayList<Integer> ans=new ArrayList<>();
        
        // -1 kiya hai because our dsu code is zero indexed and these ppl want 1 index
        for(int i=0;i<queries.length;i++ ){
            if(queries[i][0]==1){
                dsu.unionBySize(queries[i][1]-1,queries[i][2]-1);
            }else{
                ans.add(dsu.findUltParent(queries[i][1]-1)+1);
            }
        }
        return ans;
        
    }
}
