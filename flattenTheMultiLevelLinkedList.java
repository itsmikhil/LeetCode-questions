import java.util.* ;
import java.io.*; 
/*******************************************************

	Following is the Node class structure

	class Node {
	    int data;
	    Node next;
	    Node child;
	    
	    public Node(int data) {
	        this.data = data;
	    }
	}

*******************************************************/

public class Solution {
    
    public static Node flattenMultiLinkedList(Node head) {
		if(head==null){
			return head;
		}
		Queue<Node> q=new LinkedList<>();
		q.offer(head);
		Node tempHead=new Node(-1);
		// temp=10
		// tempHead->temp
		// child=4
		// 
		while(!q.isEmpty()){
			int size=q.size();
			for(int i=0;i<size;i++){
				Node temp=q.poll();
				tempHead.next=temp;
				Node prev=temp;
				while(temp!=null){
					Node child=temp.child;
					if(child!=null){
						q.offer(child);
						temp.child=null;
					}
					prev=temp;
					temp=temp.next;
				}
				tempHead=prev;
			}
		}
		return head;
    }

}