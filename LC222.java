class Solution {
    // optimal 
    
    // leftHeight == rightHeight
    // => subtree is Perfect Binary Tree
    // => nodes = 2^h - 1

    // leftHeight != rightHeight
    // => subtree is not Perfect
    // => recursively count left + right + root

    // o(log^2n) ->
    // For each recursive call, we compute left and right heights in O(log N). Since the tree is complete, one of the subtrees becomes perfect and is counted in O(1), so recursion only continues for at most log N levels. Hence total time complexity is O(log² N) and recursion stack space is O(log N).

    int findLeftHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    int findRightHeight(TreeNode root){
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=findLeftHeight(root);
        int rightHeight=findRightHeight(root);
        if(leftHeight==rightHeight) return (1<<leftHeight)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}