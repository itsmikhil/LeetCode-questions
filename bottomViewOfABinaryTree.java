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

// In top view of the tree we check before adding to the map if there is an existing node 
// from that particular line number , simply remove that checking condition that's all 
// your code for bottom view is done :)

// 1. Levl Order(BFS) use karenge + Horizontal Distance (HD) maintain karenge
// 2. Root ka HD = 0
// 3. Left child -> HD - 1
// 4. Right child -> HD + 1
// 5. Bottom View me har HD par LAST node hi answer hota hai
// 6. isliye hum map mai update karte rehenge so that LAST wala node hume mile jo ans ho
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
    public ArrayList<Integer> bottomView(Node root) {

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

                // Har HD par latest node store karte raho
                // Last stored node hi Bottom View ka answer hoga
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