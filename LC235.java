class Solution {
    TreeNode func(TreeNode root,int big,int small){
        // found lca
        if(root.val<=big && root.val>=small){
            return root;
        }
        // root.val is already bigger then big so humara lca left mai he hoga
        if(root.val>=big){
            return func(root.left,big,small);
        }else{
            // root.val is already smaller then small so humara lca right mai he hoga
            return func(root.right,big,small);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // take 2 variables big and small
        // first node .val which is between them is the is LCA
        // here we assume then LCA always exist
        // thats why we are so sure
        int big=p.val>q.val?p.val:q.val;
        int small=big==p.val?q.val:p.val;
        return func(root,big,small);
    }
}