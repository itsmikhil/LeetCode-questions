//  Brute force
// mention hai that "The "linked list" should be in the same order as a pre-order traversal of the binary tree."
class Solution {
    void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }

        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
    }
}

//  Optimal
// inplace without extra space

// mention hai that "The "linked list" should be in the same order as a pre-order traversal of the binary tree."

// we are using reverse of preorder traversal -> right left root
// we are making LL from bottom
// which is easier then making it from top

// dry run on pg 140
class Solution {

    // nextRight always points to the already flattened part.
    TreeNode nextRight=null;
    
    void helper(TreeNode root){
        if(root==null) return;

        helper(root.right);
        helper(root.left);

        root.left=null;
        root.right=nextRight;
        nextRight=root;

    }

    public void flatten(TreeNode root) {
        helper(root);
    }
}