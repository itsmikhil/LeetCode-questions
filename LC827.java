class Solution {

    // brute force:- gives TLE
    // ek 0->1 karo aur fir se pura DFS karo
    // TLE

    // better:- gives TLE
    // pehle without any chnage ak baar dfs kar lo aur maxSize of grp update karte raho
    // phir
    // ek 0->1 karo aur sirf wahi se dfs start karo aur dekho agar maxGroupSize 
    // increase ho raha hai kya?

    // optimal
    // pichle mai hum baar baar grps ko traverse kar rahe the to know their size
    // whatif hum unka size store karke rakhle map mai
    // fir hume jis 0 ko chnage karna hai uske bass neigh ka size check karna hai
    // aur hume turant size mil jayega

    // approach 1:-
    // coordinate store kare (0,0)
    // iske liye 2 baar dfs lagega
    // ek baar for finding 
    // next time for assiginging
    // TOO LONG

    // approach 2:-
    // hum haar grp ko ek unique id assign karle
    // aur wahi unique id aur size hum map mai store kar lenge
    // isse sirf 1 dfs mai kaam ho jayega
    // APPROVED

    // NOTE:-
    //  [2  2
    //  0  2]
    // in map:- 2->3 matlab 2 uniqueId wale grp ka size 3 hai
    // abhi agar hum iss 0 ke neigh ka size dekhenge toh
    // upaar 2 hai matlab map se size aaya 3
    // right 2 hai matlab map se size aaya 3
    // matlab total aayega 3+3+1(woh khud)
    // jo ki galat hai
    // soln:- hum ek hashset lenge anc check karenge ki ek unique id ka size ek he baar count ho

    int dirs[][]={{1,0},{0,1},{-1,0},{0,-1}};


    // dfs along with assigning unique id
    int dfs(int grid[][],int u,int v,int uniqueId,int count[]){
        grid[u][v]=uniqueId;
        count[0]++;
        for(int i=0;i<dirs.length;i++){
            int x=u+dirs[i][0];
            int y=v+dirs[i][1];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length &&  grid[x][y]==1){
                dfs(grid,x,y,uniqueId,count);
            }
        }
        return count[0];
    }

    public int largestIsland(int[][] grid) {
        
        // uniqueIdWhichBelongsToGroupOfIsland , itsSize
        HashMap<Integer,Integer> map=new HashMap<>();
        int uniqueId=2; // because 0,1 ko already grid mai hai
        int maxSize=0;

        // bass existing groups ka size pata karlo
        // aur unko unique id ke saath map mai store karo
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int count[]=new int[1];
                    int numOfLandsInGroup=dfs(grid,i,j,uniqueId,count);
                    map.put(uniqueId,numOfLandsInGroup);
                    uniqueId++;
                    maxSize=Math.max(maxSize,numOfLandsInGroup);
                }
            }
        }

        // all els are already 1
        if(maxSize==grid.length*grid[0].length) return maxSize;

        // jaise he koyi zero dikhe
        // uske aas pass ke neigh mai agar koyi grp hai toh 
        // uska size map se nikalke add karo
        // NOTE ek unique grp ka size ek he baar hone chaiye
        // iske liye HashSet use kiya hai
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set=new HashSet<>();
                    int grpSize=1;
                    for(int k=0;k<dirs.length;k++){
                        int u=i+dirs[k][0];
                        int v=j+dirs[k][1];
                        if(u>=0 && u<grid.length && v>=0 && v<grid[0].length && grid[u][v]!=0){
                            if(!set.contains(grid[u][v])){
                                grpSize+=map.get(grid[u][v]);
                                set.add(grid[u][v]);
                            }
                        }
                    }
                    maxSize=Math.max(maxSize,grpSize);
                }
            }
        }
        return maxSize;
    }
}


// same wahi optimal wali approach 
// DSU ke saath

class DisjointSet {
    /* To store the ranks, parents and 
    sizes of different set of vertices */
    int[] rank, parent, size;

    // Constructor
    DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Function to find ultimate parent
    int findUPar(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findUPar(parent[node]);
    }

    // Function to implement union by size
    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}

// Solution class
class Solution {
    // DelRow and delCol for neighbors
    private int[] delRow = {-1, 0, 1, 0};
    private int[] delCol = {0, 1, 0, -1};
    
    /* Helper function to check 
    if a pixel is within boundaries */
    private boolean isValid(int i, int j, int n) {
        // Return false if pixel is invalid
        if (i < 0 || i >= n) return false;
        if (j < 0 || j >= n) return false;
        
        // Return true if pixel is valid
        return true;
    }
    
    /* Function to add initial islands to 
    the disjoint set data structure */
    private void addInitialIslands(int[][] grid, 
                                   DisjointSet ds, int n) {
        // Traverse all the cells in the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // If the cell is not land, skip
                if (grid[row][col] == 0) continue;
                
                // Traverse on all the neighbors
                for (int ind = 0; ind < 4; ind++) {
                    // Get the coordinates of neighbor
                    int newRow = row + delRow[ind];
                    int newCol = col + delCol[ind];
                    
                    // If the cell is valid and a land cell
                    if (isValid(newRow, newCol, n) && 
                        grid[newRow][newCol] == 1) {
                        // Get the number for node
                        int nodeNo = row * n + col;
                        // Get the number for neighbor
                        int adjNodeNo = newRow * n + newCol;
                        
                        /* Take union of both nodes as they
                        are part of the same island */
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
    }
    
    // Function to get the size of the largest island
    public int largestIsland(int[][] grid) {
        // Dimensions of grid
        int n = grid.length;
        
        // Disjoint set data structure
        DisjointSet ds = new DisjointSet(n * n);
        
        /* Function call to add initial
        islands in the disjoint set */
        addInitialIslands(grid, ds, n);
        
        // To store the answer
        int ans = 0;
        
        // Traverse on the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                
                // If the cell is a land cell, skip
                if (grid[row][col] == 1) continue;
                
                /* Set to store the ultimate 
                parents of neighboring islands */
                Set<Integer> components = new HashSet<>();
                
                // Traverse on all its neighbors
                for (int ind = 0; ind < 4; ind++) {
                    // Coordinates of neighboring cell
                    int newRow = row + delRow[ind];
                    int newCol = col + delCol[ind];
                    
                    if (isValid(newRow, newCol, n) && 
                        grid[newRow][newCol] == 1) {
                            
                        /* Perform union and store 
                        ultimate parent in the set */
                        int nodeNumber = newRow * n + newCol;
                        components.add(ds.findUPar(nodeNumber));
                    }
                }
                
                // To store the size of current largest island
                int sizeTotal = 0;
                
                // Iterate on all the neighboring ultimate parents
                for (int parent : components) {
                    // Update the size
                    sizeTotal += ds.size[ds.findUPar(parent)];
                }
                
                // Store the maximum size of island
                ans = Math.max(ans, sizeTotal + 1);
            }
        }
        
        // Edge case
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            // Keep the answer updated
            ans = Math.max(ans, ds.size[ds.findUPar(cellNo)]);
        }
        
        // Return the answer
        return ans;
    }
}