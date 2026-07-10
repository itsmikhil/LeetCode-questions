class Solution {

    // Intuition mushkil nhi hai
    // iska implementation thodha mushkil hai

    /*
        Intuition:

        Each account is treated as one DSU node.

        Key Observation:
        - If two accounts share even one email, they belong to the same person.
        - So, they should belong to the same DSU component.

        How do we know two accounts share an email?
        - Maintain a map:
              email -> first account index where it appeared

        While traversing accounts:
        - First time seeing an email -> store its owner.
        - Email already seen -> current account and previous owner
          represent the same person, so UNION them.

        After all unions:
        - Every connected component represents one unique person.

        Last step:
        - Traverse all emails in the map.
        - Find the ultimate parent (owner) of each email.
        - Put the email inside that parent's list.
        - Sort emails and add the account name at index 0.
    */

    class disjointSet {
        ArrayList<Integer> parent;
        ArrayList<Integer> size;

        disjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();

            // Initially every account is its own parent.
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        // Path Compression
        int findUltParent(int u) {
            if (parent.get(u) == u) return u;

            parent.set(u, findUltParent(parent.get(u)));
            return parent.get(u);
        }

        // Union by Size
        void unionBySize(int u, int v) {
            int ultParentOfU = findUltParent(u);
            int ultParentOfV = findUltParent(v);

            if (ultParentOfU == ultParentOfV) return;

            if (size.get(ultParentOfU) > size.get(ultParentOfV)) {
                parent.set(ultParentOfV, ultParentOfU);
                size.set(ultParentOfU,
                        size.get(ultParentOfU) + size.get(ultParentOfV));
            } else {
                parent.set(ultParentOfU, ultParentOfV);
                size.set(ultParentOfV,
                        size.get(ultParentOfU) + size.get(ultParentOfV));
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        disjointSet ds = new disjointSet(accounts.size());

        // email -> first account that owns this email
        HashMap<String, Integer> map = new HashMap<>();

        // Build DSU by connecting accounts sharing an email.
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);

                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    // Same email => same person
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        // Stores merged emails for each DSU component.
        List<String>[] arr = new ArrayList[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            arr[i] = new ArrayList<>();
        }

        // Every email belongs to the ultimate parent of its account.
        for (String mail : map.keySet()) {
            int mailIdOwner = ds.findUltParent(map.get(mail));
            arr[mailIdOwner].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        // Prepare final merged accounts.
        for (int i = 0; i < accounts.size(); i++) {

            // This account isn't the representative.
            if (arr[i].size() == 0) continue;

            Collections.sort(arr[i]);

            // Representative's name goes at index 0.
            arr[i].add(0, accounts.get(i).get(0));

            ans.add(arr[i]);
        }

        return ans;
    }
}
