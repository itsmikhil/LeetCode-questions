
class Solution {
    int max=Integer.MIN_VALUE;
    int traverse(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=Math.max(0,traverse(root.left));
        int rightSum=Math.max(0,traverse(root.right));

        // iss node ko he final parent Node banayenge toh kitna sum aayega
        int selfSum=root.val+leftSum+rightSum;
        if(selfSum>max){
            max=selfSum;
        }

        // upaar wale ko parent banne ka mokka
        // path sum -> because we can choose only one path 
        // noth path
        int pathSum=root.val+Math.max(leftSum,rightSum);
        return pathSum;
    }
    public int maxPathSum(TreeNode root) {
       traverse(root);
       return max; 
    }
}