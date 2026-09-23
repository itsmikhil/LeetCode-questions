class DisjointSet {

        // use when you're repeatedly connecting/checking components with DSU
        // Time complexity is (4alpha)
        // while dfs and bfs is v+e
        // DSU ki specilaity hai ki woh ultparent constant time mai batata hai

        int n;
        ArrayList<Integer> size;
        ArrayList<Integer> parent;

        DisjointSet(int n) {
            this.n = n;
            rank = new ArrayList<>();
            parent = new ArrayList<>();
            // Note initialization
            // for rank initilization by 0
            // for size initialization by 1
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        // path compression
        int findUltParent(int m){
            if(m==parent.get(m)) return m;

            int ultParent=findUltParent(parent.get(m));
            parent.set(m,ultParent);

            return parent.get(m);
        }

        void unionByRank(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);

            // when they are already connected
            if(ultParentOfU==ultParentOfV) return;
            // RANK UPDATION only takes place in equal case
            // when UthComponent is bigger
            if(rank.get(ultParentOfU)>rank.get(ultParentOfV)){
                parent.set(ultParentOfV,ultParentOfU);
            }else if(rank.get(ultParentOfV)>rank.get(ultParentOfU)){
                // when either Vth component is bigger
                parent.set(ultParentOfU,ultParentOfV);
            }else{
                // when both of same rank 
                // jo koyi kisi se bhi connect ho sakta hai
                // toh jisse join ho rahe ho 
                // uska rank badega
                // here U is connecting to V
                parent.set(ultParentOfU,ultParentOfV);
                rank.set(ultParentOfV, rank.get(ultParentOfV) + 1);
            }
        }

    }