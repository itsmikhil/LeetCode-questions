class Solution {
    class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        int maxWidth = 0;

        Deque<Pair> q = new LinkedList<>();

        if (root != null)
            q.offerLast(new Pair(root, 0));

        while (!q.isEmpty()) {

            int size = q.size();

            // Leftmost index of current level
            long minIdx = q.getFirst().idx;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair temp = q.pollFirst();

                 // Normalization

                // Current level ke sabhi indices se leftmost index subtract kar rahe hain
                // Taaki numbering 0 se start ho jaye aur values chhoti rahein

                // Example:
                // Original:    100 101 105
                // Normalized:    0   1   5

                // Width same rahegi because hum sabse same value subtract kar rahe hain

                // Original Width:
                // 105 - 100 + 1 = 6

                // Normalized Width:
                // 5 - 0 + 1 = 6

                // Isliye answer affect nahi hota
                // Sirf overflow prevent hota hai

                // Normalize index to avoid overflow
                long currIdx = temp.idx - minIdx;

                if (i == 0)
                    first = currIdx;

                if (i == size - 1)
                    last = currIdx;

                if (temp.node.left != null) {
                    q.offerLast(new Pair(temp.node.left, 2 * currIdx + 1));
                }

                if (temp.node.right != null) {
                    q.offerLast(new Pair(temp.node.right, 2 * currIdx + 2));
                }
            }

            maxWidth = (int) Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}