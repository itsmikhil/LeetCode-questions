import java.util.* ;
import java.io.*; 
/*******************************************************
	Following is the BinaryTreeNode class structure

	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
			left = null
			right = null
		}
	}
*******************************************************/

public class Solution {
	static void helper(BinaryTreeNode<Integer> root,int lvl,int maxDepth[],char whichDirChild,BinaryTreeNode<Integer> deepest[]){
		if(root==null){
			return;
		}
		// System.out.println(root.data);
		if(root.left==null && root.right==null){
			if(whichDirChild=='R'){
				if(lvl>maxDepth[0]){
					maxDepth[0]=lvl;
					deepest[0]=root;
				}
			}
			return;
		}

		if(root.right!=null){
			helper(root.right,lvl+1,maxDepth,'R',deepest);
		}
		if(root.left!=null){
			helper(root.left,lvl+1,maxDepth,'L',deepest);
		}
		return;

	}
	public static BinaryTreeNode<Integer> deepestRightLeaf(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> deepest[]=new BinaryTreeNode[1];
		int maxDepth[]=new int[1];
		helper(root,0,maxDepth,'N',deepest);
		return deepest[0];
	}
}