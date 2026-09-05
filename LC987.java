// why we had to store lvl and hd both ?

// Example:
//         1
//       /   \
//      2     3
//     / \   / \
//    4   6 5   7
//
// Coordinates:
// 1 -> (hd=0, lvl=0)
// 6 -> (hd=0, lvl=2)
// 5 -> (hd=0, lvl=2)
//
// If we store only values for hd=0:
// [1, 6, 5]   (preorder visits left subtree first)

// for same hd we had to sort by value -> as per question

// But expected output is:
// [1, 5, 6]
//
// Hence we must store:
// hd  -> to group nodes into the same vertical column.
// lvl -> to sort nodes top-to-bottom.
// val -> if hd & lvl are same, sort by value.

class Pair {
    int lvl;
    int val;

    Pair(int lvl, int val) {
        this.lvl = lvl;
        this.val = val;
    }
}

class Solution {

    void preorder(TreeNode root, int hd, int lvl,
                  TreeMap<Integer, List<Pair>> map) {

        if (root == null) return;

        // hd -> identifies the vertical column.
        // lvl -> preorder doesn't guarantee top-to-bottom order.
        // val -> used when two nodes have the same row & column.
        map.putIfAbsent(hd, new ArrayList<>());
        map.get(hd).add(new Pair(lvl, root.val));

        preorder(root.left, hd - 1, lvl + 1, map);
        preorder(root.right, hd + 1, lvl + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<Pair>> map = new TreeMap<>();

        preorder(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Pair> list : map.values()) {

            Collections.sort(list, (a, b) -> {
                if (a.lvl != b.lvl)
                    return a.lvl - b.lvl;
                return a.val - b.val;
            });

            List<Integer> temp = new ArrayList<>();
            for (Pair p : list)
                temp.add(p.val);

            ans.add(temp);
        }

        return ans;
    }
}