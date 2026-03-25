// done with recursion
// iteration is easier
class Solution {
    ListNode func(ListNode temp, int val){
        if(temp==null){
            return null;
        }
        temp.next=func(temp.next,val);
        if(temp.val==val){
            return temp.next;
        }else{
            return temp;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        head=dummy;
        return func(head,val).next;
    }
}