public class Codec {
    // we can use any method for serilization
    
    // approach 1:- preorder
//     TreeNode build(){
    //     if(curr.equals("#")) return null;

    //     TreeNode root=new TreeNode(val);
    //     root.left=build();
    //     root.right=build();

    //     return root;
    // }

    // approach 2:- preorder and inorder -> lengthy

    // approach 3:- level order(curr one)

    // Level order use karke string banayi hai
    // fir wahi string ko use karke same tree structure create kiya hai
    // used StringBuilder instead of String for better TC
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        if(root!=null){
            q.offer(root);
            ans.append(Integer.toString(root.val));
        } 
        while(!q.isEmpty()){
            ans.append(' ');
            TreeNode temp=q.poll();
            if(temp.left!=null){
                q.offer(temp.left);
                ans.append(Integer.toString(temp.left.val));
            }else{
                ans.append('#');
            }
            ans.append(' ');
            if(temp.right!=null){
                q.offer(temp.right);
                ans.append(Integer.toString(temp.right.val));
            }else{
                ans.append('#');
            }
        }
        return ans.toString();
    }   

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int i=0;
        if(data.equals("")) return null;
        String arr[]=data.split(" ");
        TreeNode root=new TreeNode(Integer.parseInt(arr[i]));
        i++;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(i<arr.length){
            TreeNode temp=q.poll();

            if(!arr[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(arr[i]));
                temp.left=left;
                q.offer(left);
            }
            i++;

            if(!arr[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(arr[i]));
                temp.right=right;
                q.offer(right);
            }
            i++;

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));