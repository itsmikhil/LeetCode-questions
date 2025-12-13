class Solution {
    int sum=0;
    public void inorder(TreeNode root,int parVal,int grandParVal){
        if(root==null){
            return;
        }
        inorder(root.left,root.val,parVal);
        if(grandParVal!=-1 && grandParVal%2==0){
            sum+=root.val;
        }
        inorder(root.right,root.val,parVal);
    }
    public int sumEvenGrandparent(TreeNode root) {
        inorder(root,-1,-1);
        return sum;
    }
}
