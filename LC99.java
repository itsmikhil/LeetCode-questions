
class Solution {
    // optimal
    // o(N)
    
    // case 1
    // [3,25,7,8,10,15,20,5]
    // first voilation when prev=25 and curr=7
    // so hum first=25 and middle =7 store kar lenge
    // second voilation comes at prev=20 and curr=5
    // toh hum second=5 store kar lenge
    // aur abhi hum first aur second ki values swap kar lenge so that tree sorted ho jaye

    // case 2- yaha middle ka kaam samajh aayega
    // [3,5,8,7,10,15,20]
    // first voilation comes at prev=8 and curr=7
    // so we store first=8 and middle as 7
    // aage aur koyi voilation nhi hai
    // matlab ye dono mai he dikkat hai
    // inn dono ki values he swap karenge and tree fix ho jayega

    void inorderTraversal(TreeNode root,TreeNode arr[],TreeNode prev[]){
        if(root==null) return;
        inorderTraversal(root.left,arr,prev);
        if(prev[0]!=null && prev[0].val>root.val){
            // 
            if(arr[0]==null){
                arr[0]=prev[0]; // first
                arr[1]=root; // middle
            }else{
                arr[2]=root; // second
            }
        }
        prev[0]=root;
        inorderTraversal(root.right,arr,prev);
    }
    public void recoverTree(TreeNode root) {
        TreeNode arr[]=new TreeNode[3]; // [first,middle,second]
        TreeNode prev[]=new TreeNode[1];
        // Initialize prev with minimum possible value
        prev[0]=new TreeNode(Integer.MIN_VALUE);
        inorderTraversal(root,arr,prev);
        // Non-adjacent swapped nodes
        if(arr[2]!=null){
            int temp=arr[0].val;
            arr[0].val=arr[2].val;
            arr[2].val=temp;
        }else{
            // Adjacent swapped nodes
            int temp=arr[1].val;
            arr[1].val=arr[0].val;
            arr[0].val=temp;
        }
        return;
    }
}