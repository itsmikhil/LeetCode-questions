class Solution {
    boolean result=true;
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        if(left==-1){
            return -1;
        }
        int right=height(root.right);
        if(right==-1){
            return -1;
        }
        int dif=left>right?left-right:right-left;
        if(dif>1){
            result=false;
            return -1;
        }
        return Math.max(left,right)+1;
        
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    
    }
}