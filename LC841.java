class Solution {

    // Simple DFS

    void DFS(int node,List<List<Integer>> rooms,boolean vis[]){
        if(vis[node]==true){
            return;
        }
        vis[node]=true;
        for(int i:rooms.get(node)){
            if(vis[i]==false){
                DFS(i,rooms,vis);
            }
        }

    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        DFS(0,rooms,vis);
        for(boolean i:vis){
            if(i==false){
                return i;
            }
        }
        return true;
    }
}