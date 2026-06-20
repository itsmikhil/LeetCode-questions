class Solution {
    // optimal

    
    // Previous BST Iterator question me jo lazy inorder traversal use kiya tha,
    // wahi yaha ascending iterator ki tarah use kar rahe hai.
    //
    // Descending iterator ke liye bas usi logic ko reverse kar diya:
    // Right -> Root -> Left
    //
    // Isse inorder traversal ko store karne wali O(N) auxiliary space
    // avoid ho jaati hai aur sirf O(H) stack space use hoti hai.

    TreeNode ascPop(Stack<TreeNode> s1){
        TreeNode temp=s1.pop();
        TreeNode res=temp;
        if(temp.right!=null){
            temp=temp.right;
            while(temp!=null){
                s1.push(temp);
                temp=temp.left;
            }
        }
        return res;
    }

    TreeNode descPop(Stack<TreeNode> s2){
        TreeNode temp=s2.pop();
        TreeNode res=temp;
        if(temp.left!=null){
            temp=temp.left;
            while(temp!=null){
                s2.push(temp);
                temp=temp.right;
            }
        }
        return res;
    }

    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        TreeNode temp=root;
        while(temp!=null){
            s1.push(temp);
            temp=temp.left;
        }

        temp=root;
        while(temp!=null){
            s2.push(temp);
            temp=temp.right;
        }

        int sum=0;
        TreeNode left=ascPop(s1);
        TreeNode right=descPop(s2);
        sum=left.val+right.val;

        while(!s1.isEmpty() && !s2.isEmpty() && left.val<right.val){
            if(sum==k){
                return true;
            }else if(sum<k){
                left=ascPop(s1);
            }else if(sum>k){
                right=descPop(s2);
            }
            sum=left.val+right.val;
        }
        return false;
    }
}