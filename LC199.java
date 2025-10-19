class Solution {
    List<Integer> ans=new ArrayList<>();
    // lvl is nothing but hori dis
    public void revPreOrder(int level,TreeNode root){
        if(root==null){
            return;
        }
        if(level==ans.size()){
            ans.add(root.val);
        }
        revPreOrder(level+1,root.right);
        revPreOrder(level+1,root.left);
        return;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return ans;
        }
        revPreOrder(0,root);
        return ans;
    }
}