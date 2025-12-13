class Solution {
    int sum=0;
    int maxLvl=-1;
    void findLvl(TreeNode root,int lvl){
        if(root==null){
            return;
        }
        findLvl(root.left,lvl+1);
        // curr lvl max hai matlab pichla sum bhul jao
        if(lvl>maxLvl){
            maxLvl=lvl;
            sum=root.val;
        }else if(lvl==maxLvl){
            sum+=root.val;
        }
        findLvl(root.right,lvl+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        findLvl(root,0);
        return sum;
    }
}
