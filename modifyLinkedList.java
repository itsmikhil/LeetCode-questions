import java.util.* ;
import java.io.*; 
/****************************************************************
    Following is the Linked List Node structure

    class Node
    {
    public:
        int data;
        Node *next;
        Node(int data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/

public class Solution{
	public static Node modifyLL(Node head){
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
		// we will find the mid
        // reverse the second half and then merge them
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=slow.next;
        Node prev=null;
        slow.next=null;
        while(temp!=null){
            Node next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }

        Node leftHead=head;
        Node rightHead=prev;
        // 1 2 3 4 5

        while(rightHead!=null && leftHead!=null){
            Node leftNext=leftHead.next;
            leftHead.next=rightHead;
            Node rightNext=rightHead.next;
            rightHead.next=leftNext;
            rightHead=rightNext;
            leftHead=leftNext;
        }
        return head;
	}
}