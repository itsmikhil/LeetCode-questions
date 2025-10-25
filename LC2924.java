class Solution {
    public int findChampion(int n, int[][] edges) {

        // easy jiss team ka koyi incmoing edge nhi hai woh strong team hai
        // agar more than 1 string team hai toh return -1
        // or agar sirf ek strong team hai toh uska index return karo
        
        int incomingEdges[]=new int[n];
        for(int edge[]:edges){
            incomingEdges[edge[1]]++;
        }
        int ans=-1;
        int count=0;
        for(int i=0;i<incomingEdges.length;i++){
            if(incomingEdges[i]==0){
                ans=i;
                count++;
            }
        }
        return count==1?ans:-1;
    }
}