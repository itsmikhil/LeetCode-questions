class Solution {
    public ListNode swapPairs(ListNode head) {
        // 1->2->3->4->x
        // prev->first->sec->third
        // notebook pe draw karo apne aap code samajh aata hai
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        head=dummy;
        ListNode prev=head;
        ListNode first=prev.next;
        ListNode sec=first.next;
        ListNode third=sec.next;
        while(true){
            prev.next=sec;
            sec.next=first;
            first.next=third;
            if(third==null|| third.next==null){
                break;
            }
            prev=first;
            first=third;
            sec=first.next;
            third=sec.next;
        }
        return head.next;
    }
}