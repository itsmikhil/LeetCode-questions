class Solution {
    // Important question
    // optimal - o(n) o(height)
    // thodha samjh lo toh mushkil nhi hai
    // also keep brute force in mind
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case and
        // if we found any of the target node then return the node
        if(root==null || root==p || root==q){
            return root;
        }
        // agar target node mil jaye toh right-left jana he nhi hai
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        // when we have found the node from right 
        // thats why send the right node 
        if(left==null){
            return right;
        }
        // when we have found the node from left 
        // thats why send the left node 
        if(right==null){
            return left;
        }
        // when left and right both are not null
        // means this is our LCA
        // send this ahead
        return root;
    }
}