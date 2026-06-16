class Solution {
    // Brute force
    // o(n^2)
    // for every node we are finding its height
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

class Solution {
    // Optimal
    // Important samjh lo
    // ek he baar height find karne ne hume pata lag raha hai agar tree mai gadbad hai
    // o(n)
    int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=height(root.left);
        if(left==-1) return -1;

        int right=height(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
}