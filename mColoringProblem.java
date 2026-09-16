class Solution {
    
    // haar node ko haar color assign kar rahe hai
    // aur fir uske neighbours ke saath check kar rahe
    // agar woh sahi hai toh aage badho
    // warna backtrack
    
    // tc:(numOfColours^numOfVertices)*NumOfEdges
    // har vertex he ke liye saare colours ke choice hai
    // aur haar iteration mai saare neigh check kar rahe hai
    // if its safe or no
    // isliye num of Edges se multiply
    
    boolean isSafe(ArrayList<ArrayList<Integer>> adj,int colour[],int currNode,int currColour){
        for(int neigh:adj.get(currNode)){
            if(colour[neigh]==currColour){
                return false;
            }
        }
        return true;
    }
    
    boolean checkColouring(ArrayList<ArrayList<Integer>> adj,int colour[],int currNode,int numOfColours){
        if(currNode==adj.size()){
            return true;
        }
        for(int currColour=1;currColour<=numOfColours;currColour++){
            if(isSafe(adj,colour,currNode,currColour)){
                colour[currNode]=currColour;
                boolean ans=checkColouring(adj,colour,currNode+1,numOfColours);
                if(ans==true){
                    return ans;
                }
                colour[currNode]=0;
            }
        }
        return false;
    }
    
    boolean graphColoring(int v, int[][] edges, int m) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        int colour[]=new int[v];
        return checkColouring(adj,colour,0,m);
    }
}