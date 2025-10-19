class Solution {
    TreeNode findMinVal(TreeNode root){
        TreeNode curr=root;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            root.val=findMinVal(root.right).val;
            root.right=deleteNode(root.right,root.val);
        }
        return root;
    }
}