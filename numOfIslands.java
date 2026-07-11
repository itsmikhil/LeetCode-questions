class Solution {
    
    // matrix ke haar el ki numbering => currRowNum*totalCols+currColNum
    
    // Crucial case G1ofIsaland , G2ofIsland ==> count=2
    // a new land comes and connectes these 2 grps
    // newcount=1
    
    // TC:- n*alpha
    
    
    // check if the coordinates are valid
    boolean isValid(int u,int v,int numOfRows,int numOfCols){
        return u>=0 && u<numOfRows && v>=0 && v<numOfCols;
    }
    
    class disjointSet{
        ArrayList<Integer> parent;
        ArrayList<Integer> size;
        disjointSet(int n){
            parent=new ArrayList<>();
            size=new ArrayList<>();
            for(int i=0;i<n;i++){
                parent.add(i);
                size.add(1);
            }
        }
        int findUltParent(int u){
            if(parent.get(u)==u) return u;
            parent.set(u,findUltParent(parent.get(u)));
            return parent.get(u);
        }
        void unionBySize(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);
            if(ultParentOfU==ultParentOfV) return;
            if(size.get(ultParentOfU)>size.get(ultParentOfV)){
                parent.set(ultParentOfV,ultParentOfU);
                size.set(ultParentOfU,size.get(ultParentOfU)+size.get(ultParentOfV));
            }else{
                parent.set(ultParentOfU,ultParentOfV);
                size.set(ultParentOfV,size.get(ultParentOfV)+size.get(ultParentOfU));
                
            }
        }
    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        disjointSet ds=new disjointSet(rows*cols);
        // to see of a el is water or land
        // true=>land
        // false=>water
        boolean[][] vis = new boolean[rows][cols];
        int numOfIsland=0;
        int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<operators.length;i++){
            int u=operators[i][0];
            int v=operators[i][1];
            
            // what if i am already a land
            // if i am already a land means that 
            // i am already counted as islans and 
            // also connected with my groupOfIsalnd
            if(vis[u][v]){
                ans.add(numOfIsland);
                continue;
            }
            
            // naya naya island
            vis[u][v] = true;
            
            // assuming woh akela hai aur uske koyi neigh water nhi hai
            // increment kar diya
            numOfIsland++;
            
            // check of their is a islans grp that i can join
            for(int j=0;j<dirs.length;j++){
                int adjU=u+dirs[j][0];
                int adjV=v+dirs[j][1];
                // if i am joining a existing island grp then 
                // count needs to be decremented
                if(isValid(adjU,adjV,rows,cols) && vis[adjU][adjV]){
                    if(ds.findUltParent(u*cols+v)!=ds.findUltParent(adjU*cols+adjV)){
                        numOfIsland--;
                        ds.unionBySize(u*cols+v,adjU*cols+adjV);
                    }
                }
            }
            
            ans.add(numOfIsland);
        }
        
        return ans;
        
    }
}