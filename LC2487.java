
// recursive solution
// no need to pass any max variable
// just access the val of next node
class Solution {
    ListNode func(ListNode temp){
        if(temp.next==null){
            return temp;
        }
        temp.next=func(temp.next);
        if(temp.val>=temp.next.val){
            return temp;
        }else{
            return temp.next;
        }
        
    }
    public ListNode removeNodes(ListNode head) {
        return func(head);
    }
}