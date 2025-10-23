class Solution {

    public void DFS(int[][] isConnected,boolean visi[],int s){
        visi[s]=true;
        for(int i=0;i<isConnected[s].length;i++){
            if(isConnected[s][i]==1 && visi[i]!=true){
                DFS(isConnected,visi,i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean visi[]=new boolean[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visi[i]!=true){
                DFS(isConnected,visi,i);
                count++;
            }
        }
        return count;
    }
}