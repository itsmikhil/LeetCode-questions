class BSTIterator {
    // Optimal
    // Assan he hai but samjh le

    // This approach is also performing an Inorder Traversal
    // (Left -> Root -> Right), but lazily.
    //
    // Earlier approach:
    // 1. Perform complete inorder traversal.
    // 2. Store all nodes in an ArrayList.
    // 3. Move an index forward in next().
    //
    // Drawback:
    // - We compute the entire traversal even if only a few next()
    //   calls are made.
    // - Extra space O(N) for storing all node values.
    //
    // Current approach:
    // - Store only the path needed to reach the next smallest element.
    // - Stack simulates the recursion stack of inorder traversal.
    // - We generate elements one by one when next() is called.
    //
    // Space:
    // O(H) where H = height of BST
    // (Only nodes along one root-to-leaf path are stored)
    //
    // Time:
    // Constructor: O(H)
    // next(): Amortized O(1)
    // hasNext(): O(1)

    Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {

        s = new Stack<>();

        // Push all left nodes because
        // in inorder traversal the leftmost node
        // is visited first.
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public int next() {

        // Top of stack is always the next inorder node.
        TreeNode temp = s.pop();
        int res = temp.val;

        // After visiting a node in inorder,
        // we must process its right subtree.
        //
        // For that right subtree, again push all
        // its left descendants because they must
        // be visited before anything else.
        if (temp.right != null) {
            temp = temp.right;

            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }
        }

        return res;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}