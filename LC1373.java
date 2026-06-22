// optimal

// intuition in notes of sheet

class NodeValue{
    int minVal;
    int maxVal;
    int maxSize; // it is not needed in this question , but this variation can also be asked for same question
    int sum;
    NodeValue(int minVal,int maxVal,int maxSize,int sum){
        this.minVal=minVal;
        this.maxVal=maxVal;
        this.maxSize=maxSize;
        this.sum=sum;
    }
}
class Solution {
    int maxSum=Integer.MIN_VALUE;
    // POSTORDER because we need left and right for computation
    NodeValue postOrder(TreeNode root){
        if(root==null) return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0,0);
        NodeValue left=postOrder(root.left);
        NodeValue right=postOrder(root.right);

        // Current node must be greater than the maximum value in left subtree
        // and smaller than the minimum value in right subtree.
        // when its a valid BST
        // so size=left.size +right.size+1;
        // sum=left.sum+right.sum+root.val
        if(left.maxVal<root.val && root.val<right.minVal){
            // updating maxSum
            maxSum=Math.max(maxSum,left.sum+right.sum+root.val);
            return new NodeValue(Math.min(root.val,left.minVal),Math.max(root.val,right.maxVal),left.maxSize+right.maxSize+1,left.sum+right.sum+root.val);
        }

        // Current subtree is not a BST.
        // min=Integer.MIN_VALUE and max=Integer.MAX_VALUE
        // sum and size is irrelevant because this subtree will never
        // be used in a valid BST computation above.
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,0,0);
    }
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        int ans=maxSum;
        return Math.max(ans,0);
    }
}