class DisjointSet {
        int n;
        ArrayList<Integer> size;
        ArrayList<Integer> parent;

        DisjointSet(int n) {
            this.n = n;
            size = new ArrayList<>();
            parent = new ArrayList<>();
            // Note initialization
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        int findUltParent(int m){
            if(m==parent.get(m)) return m;

            int ultParent=findUltParent(parent.get(m));
            parent.set(m,ultParent);

            return parent.get(m);
        }

        void unionBySize(int u,int v){
            int ultParentOfU=findUltParent(u);
            int ultParentOfV=findUltParent(v);

            // when they are already connected
            if(ultParentOfU==ultParentOfV) return;
            // when UthComponent is bigger
            if(size.get(ultParentOfU)>size.get(ultParentOfV)){
                parent.set(ultParentOfV,ultParentOfU);
                size.set(ultParentOfU,size.get(ultParentOfU)+size.get(ultParentOfV));
            }else{
                // when either Vth component is bigger
                // or both are of SAME size
                parent.set(ultParentOfU,ultParentOfV);
                size.set(ultParentOfV,size.get(ultParentOfU)+size.get(ultParentOfV));
            }
        }

    }