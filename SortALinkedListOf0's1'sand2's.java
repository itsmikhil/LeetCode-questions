/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // dummy nodes
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);
        
        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;
        Node temp=head;
        
        // teeno ko alah alag LL bana do
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
            }else if(temp.data==1){
                one.next=temp;
                one=one.next;
            }else if(temp.data==2){
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        
        // HAAR LL KA PEHLA NODE DUMMY HAI TOH HANDLING THAT AS WELL 
        // hume chaiye zero LL ki tail ka next should be one LL ka head
        // but what if 1's ho he na
        // isliye hum check kar rahe hai ki oneHead.next ko point karna hai kya twoHead.next ko
        zero.next=oneHead.next!=null?oneHead.next:twoHead.next;
        // we want to point TwoHead.next no matter if its exist or not
        // agar 2's exist nhi karta toh oneLL ka tail would point to two.next (which will be null)
        one.next=twoHead.next;
        // Stopper laga rahe hai so that loop na ban jaye
        two.next=null;
        // maan lo zero's exist nhi karte toh zeroDummyNode will still point to actual oneHead 
        // which is still zeroHead.next
        // therefore all cases handled
        return zeroHead.next;
        
    }
}