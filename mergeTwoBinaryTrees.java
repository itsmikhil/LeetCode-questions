class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }
        if((root1!=null && root2==null) || (root1==null && root2!=null)){
            // pass the entire subtree
            return root1!=null?root1:root2;
        }else{
            root2.val+=root1.val;
        }
        root2.left=mergeTrees(root1.left,root2.left);
        root2.right=mergeTrees(root1.right,root2.right);
        return root2;
    } 
}