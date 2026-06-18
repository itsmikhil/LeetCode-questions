class Solution {
    // approach :-o(n) o(n)
    // First element of preorder is always the root.
    // Find this root in inorder.
    // Elements left of root in inorder belong to left subtree.
    // Elements right of root in inorder belong to right subtree.
    // Number of nodes in left subtree helps us split preorder as well.
    // Repeat the same process recursively.

    // dry run:-
    // preorder = [3,9,20,15,7] inorder = [9,3,15,20,7]
    // 3 is root
    // inorder array mai 3 find karo 
    // isse left aur right subtree ke vals milte hai [9] 3 [15 20 7]
    // lekin inka order hume abhi bhi nhi pita
    // abb hum yahi same process left aur right subtree ke liye karenge
    // inorder array partitioning se hume pata chala left mai ek el hai
    // aur right mai 3 el hai
    // because hume num of els pata hai left aur right subtree mai toh hum unka preorder bhi
    // pata kar sakte hai
    // left subtree:- preorder :- [9] inorder:- [9]
    // right subtree:- preorder:- [20 15 7] inorder:- [15 20 7]
    // abb ye dono apne aap mai alag question hai
    // - same wahi preorder se root nikalo usse inorder mai findkaro
    // - left aur right subtree ke num of els nikalo
    // - aur fir preorder array aur inorder array ka hissa aage pass karo

    TreeNode constructTree(int preorder[],int preStart,int preEnd,HashMap<Integer,Integer> inorderMap,int inorder[],int inStart,int inEnd){
        // base case
        if(preStart>preEnd || inStart>inEnd) return null;

        // first el in preorder is our Root
        TreeNode root=new TreeNode(preorder[preStart]);
        
        // find Root in inorder array
        // we has stored inorder els in HASHMAP so that we get their index in const time --> IMP
        int idxOfRootInInorderArray=inorderMap.get(preorder[preStart]);

        // find num of els on left side
        int numsOnLeftSide=idxOfRootInInorderArray-inStart;

        // split preorder and inorder array for left subtree
        root.left=constructTree(preorder,preStart+1,preStart+numsOnLeftSide,inorderMap,inorder,inStart,idxOfRootInInorderArray-1);

        // split preorder and inorder array for right subtree
        root.right=constructTree(preorder,preStart+numsOnLeftSide+1,preEnd,inorderMap,inorder,idxOfRootInInorderArray+1,inEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // store inorder els in hashmap so so we get req val's idx in o(1)
        HashMap<Integer,Integer> inorderMap=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return constructTree(preorder,0,preorder.length-1,inorderMap,inorder,0,inorder.length-1);
    }
}