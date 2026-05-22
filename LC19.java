class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // we are eliminating time wasted in finding length
        // base case
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        // fast ko k steps move karo
        for(int i=0;i<n && fast!=null;i++){
            fast=fast.next;
        }
        // matlab head remove hoga case
        if(fast==null){
            return head.next;
        }
        // dono ko ek ek step move karo
        // jaise he fast.next==null hoga tabhi slow jo bhi node ko remove karna hai uske prev pe khada hoga
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}