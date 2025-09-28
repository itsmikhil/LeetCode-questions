class Solution {
    // first look at the diagram and try to get inituition of reverseInorder
    // then we get to know that we need to maintain a sum var
    // whihc tracks sum of visited nodes
    // and we need to keep sum outside becuase 
    // if we pass it in func recursively then main root ko zero pass karenge while calling function
    // whihc is in correct

    int sum=0;
    
    public TreeNode antiInorder(TreeNode root){
        if(root==null){
            return null;
        }
        antiInorder(root.right);
        sum+=root.val;
        root.val=sum;
        antiInorder(root.left);
        return root;
    }
    public TreeNode bstToGst(TreeNode root) {
        return antiInorder(root);
    }
}