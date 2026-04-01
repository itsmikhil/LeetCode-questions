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