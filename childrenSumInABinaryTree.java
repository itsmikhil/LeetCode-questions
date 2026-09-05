
class Solution {
    
    static long traverse(Node root){
        // when root is null
        if(root==null) return 0;
        
        // leaf node
        if(root.left==null && root.right==null) return root.data;
        
        // get leftSum 
        long left=traverse(root.left);
        
        // left se invalid aagaya toh usse he pass kardo aage
        if(left==Long.MAX_VALUE) return left;
        
        // get rightSum 
        long right=traverse(root.right);
        
        // right se invalid aagaya toh usse he pass kardo aage
        if(right==Long.MAX_VALUE) return right;
        
        // agar leftSum+rightSum!=root.val return false
        if(left+right!=root.data) return Long.MAX_VALUE;
        
        // true condition
        return root.data;
        
    }
    public boolean isSumProperty(Node root) {
        
        return traverse(root)!= Long.MAX_VALUE;
        
    }
}