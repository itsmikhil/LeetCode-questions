class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // har node se har jagah jaa rahe hai
        // Floyd warshall 

        // tc:O(N²) + O(E) + O(N³) + O(N²)
        // = O(N³)
        // sc: o(n^2)

        int dis[][]=new int[n][n];

        // set all to INF
        for(int i=0;i<dis.length;i++){
            Arrays.fill(dis[i],(int)1e9);
        }

        // make adj matrix
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dis[u][v]=wt;
            dis[v][u]=wt;
        }

        // khud pr travel karne ka cost zero
        for(int i = 0; i < n; i++){
            dis[i][i] = 0;
        }

        // apne basic floyd warshall lagne do
        // threshold wala check BAAD mai karenge
        for(int via=0;via<n;via++){
            for(int i=0;i<dis.length;i++){
                for(int j=0;j<dis[0].length;j++){
                    if(dis[i][via]!=(int)1e9 && dis[via][j]!=(int)1e9){
                        int newDis=dis[i][via]+dis[via][j];
                        dis[i][j]=Math.min(newDis,dis[i][j]);
                    }
                }
            }
        }

        // yaha pe haar row ke liye max reachable cities dekho within threshold
        // and jiska bhi sabse kam ko usse return kardo
        int minCount=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<dis.length;i++){
            int count=0;
            for(int j=0;j<dis[0].length;j++){
                if(dis[i][j]<=distanceThreshold){
                    count++;
                }
            }
            // equal to helps us in returning greater row number in case of tie
            if(count<=minCount){
                minCount=count;
                ans=i;
            }
        }
        return ans;
    }
}