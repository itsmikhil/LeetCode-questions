class Solution {
    public int pairSum(ListNode head) {
        // approach 1-stack
        Stack<Integer> s=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            s.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        int max=0;
        int n=s.size();
        for(int i=0;i<n/2;i++){
            max=Math.max(max,temp.val+s.pop());
            temp=temp.next;
        }
        return max;
    }
}

class Solution {
    public int pairSum(ListNode head) {
        // approach 2-reverse 2nd half
        ListNode slow=head;
        ListNode fast=head.next;
        int size=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            size++;
        }
        ListNode prev=slow;
        ListNode curr=slow.next;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode temp=head;
        ListNode right=prev;
        ListNode left=head;
        int max=0;
        for(int i=0;i<size+1;i++){
            max=Math.max(max,left.val+right.val);
            left=left.next;
            right=right.next;
        }
        return max;
    }
}