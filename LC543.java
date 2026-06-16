class Solution {
    // Brute force
    // o(n^2)
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int leftLargestPath=diameterOfBinaryTree(root.left);
        int rightLargestPath=diameterOfBinaryTree(root.right);
        int max=Math.max(rightLargestPath,Math.max(leftLargestPath,leftHeight+rightHeight));
        return max;
    }
}
class Solution {
    // Optimal
    // o(n)
    // height find karte karte he dia bhi store kar rahe hai ARRAY mai
    // because array is pass by reference
    int height(TreeNode root,int dia[]){
        if(root==null){
            return 0;
        }
        int left=height(root.left,dia);
        int right=height(root.right,dia);
        dia[0]=Math.max(dia[0],left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int dia[]=new int[1];
        height(root,dia);
        return dia[0];
    }
}