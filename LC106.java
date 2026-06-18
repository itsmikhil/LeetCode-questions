class Solution {

    // approach :- o(n) o(n)
    // Last element of postorder is always the root.
    // Find this root in inorder.
    // Elements left of root in inorder belong to left subtree.
    // Elements right of root in inorder belong to right subtree.
    // Number of nodes in left subtree helps us split postorder as well.
    // Repeat the same process recursively.

    TreeNode constructTree(int postorder[],int postStart,int postEnd,HashMap<Integer,Integer> inorderMap,int inorder[],int inStart,int inEnd){
        // base case
        if(postStart>postEnd || inStart>inEnd) return null;

        // last el in postorder is our Root
        TreeNode root=new TreeNode(postorder[postEnd]);
        
        // find Root in inorder array
        // we has stored inorder els in HASHMAP so that we get their index in const time --> IMP
        int idxOfRootInInorderArray=inorderMap.get(postorder[postEnd]);

        // find num of els on left side
        int numsOnLeftSide=idxOfRootInInorderArray-inStart;

        // split postorder and inorder array for left subtree
        root.left=constructTree(postorder,postStart,postStart+numsOnLeftSide-1,inorderMap,inorder,inStart,idxOfRootInInorderArray-1);

        // split postorder and inorder array for right subtree
        root.right=constructTree(postorder,postStart+numsOnLeftSide,postEnd-1,inorderMap,inorder,idxOfRootInInorderArray+1,inEnd);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inorderMap=new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return constructTree(postorder,0,postorder.length-1,inorderMap,inorder,0,inorder.length-1);
    }
}