/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

//solved in gfg

class Solution {
    void addLeftNodes(ArrayList<Integer> ans,Node root){
        Node temp=root.left;
        while(temp!=null){
            if(!isLeaf(temp)){
                ans.add(temp.data);
            }
            if(temp.left!=null){
                temp=temp.left;
            }else{
                temp=temp.right;
            }
        }
    }
    
    boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }
    
    void preorder(ArrayList <Integer> ans,Node root){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            ans.add(root.data);
        }
        preorder(ans,root.left);
        preorder(ans,root.right);
    }
    
    void addRightNodes(ArrayList <Integer> ans,Node root){
        ArrayList<Integer> tempList=new ArrayList<Integer>();
        Node temp=root.right;
        while(temp!=null){
            if(!isLeaf(temp)){
                tempList.add(temp.data);
            }
            if(temp.right!=null){
                temp=temp.right;
            }else{
                temp=temp.left;
            }
        }
        for(int i=tempList.size()-1;i>=0;i--){
            ans.add(tempList.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> ans=new ArrayList<Integer>();
       if(root==null){
           return ans;
       }
       if(isLeaf(root)){
           ans.add(root.data);
           return ans;
       }
       ans.add(root.data);
       addLeftNodes(ans,root);
       preorder(ans,root);
       addRightNodes(ans,root);
        return ans;
    }
}