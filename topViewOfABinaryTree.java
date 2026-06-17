/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

// 1. BFS use karenge + Horizontal Distance (HD) maintain karenge
// 2. Root ka HD = 0
// 3. Left child -> HD - 1
// 4. Right child -> HD + 1
// 5. Top View me har HD par pehla node hi answer hota hai
// 6. Isliye agar HD pehle se map me nahi hai tabhi store karo
// 7. TreeMap use kiya taaki HD sorted order me mile
// 8. End me TreeMap ke values answer ban jayengi

// Queue me node ke saath uska Horizontal Distance (HD) bhi store karna hai
class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
    public ArrayList<Integer> topView(Node root) {

        // HD -> Node Value
        // TreeMap use kiya for automatic sorting of HDs
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // BFS queue
        Queue<Pair> q = new LinkedList<>();

        // Root ka HD = 0
        if (root != null)
            q.offer(new Pair(root, 0));

        // Normal BFS
        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair temp = q.poll();

                // Agar is HD par pehli baar node mila hai
                // toh wahi Top View me dikhega
                if (map.get(temp.hd) == null)
                    map.put(temp.hd, temp.node.data);

                // Left child -> HD - 1
                if (temp.node.left != null)
                    q.offer(new Pair(temp.node.left, temp.hd - 1));

                // Right child -> HD + 1
                if (temp.node.right != null)
                    q.offer(new Pair(temp.node.right, temp.hd + 1));
            }
        }

        // Sorted HD order me answer store karo
        ArrayList<Integer> list = new ArrayList<>();

        for (int val : map.values()) {
            list.add(val);
        }

        return list;
    }
}