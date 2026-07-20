// Brute Force
// Sab Els ko AL mai daalo
// Sort karo aur new LL banake return kardo
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                arr.add(temp.val);
                temp=temp.next;
            }
        }
        Collections.sort(arr);
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        for(int i=0;i<arr.size();i++){
            ListNode temp=new ListNode(arr.get(i));
            curr.next=temp;
            curr=curr.next;
        }
        return dummy.next;
    }
}
class Solution {
    // Better 
    // do do karke LL ko merge karte jao IN PLACE

    // TC:
    // assume sab list mai n els hai
    // first call mai n nodes traverse
    // second call mai n+n=>2n nodes traverse
    // third call mai 2n+n=>3n nodes traverse
    // aise karte karte assume k calls hue
    // toh (n+2n+3n+4n....kn)
    // which is n(k(k+1)/2)=>n(k^2)
    ListNode merge2LL(ListNode list1,ListNode list2){
        if(list1==null)return list2;
        if(list2==null)return list1;
        if(list1.val<=list2.val){
            list1.next=merge2LL(list1.next,list2);
            return list1;
        }else{
            list2.next=merge2LL(list1,list2.next);
            return list2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp=null;
        for(int i=0;i<lists.length;i++){
            temp=merge2LL(temp,lists[i]);
        }
        return temp;
    }
}
// optimal
// min heap
// pehle toh saare nodes ko minheap mai daaldo
// fir minheap aapko sabse min val wala node deta rahega 
// usko use karke new LL banake return kardo
class Solution {
    class node{
        ListNode Node;
        int val;
        node(ListNode Node){
            this.Node=Node;
            val=Node.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<node> q=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                q.add(new node(lists[i]));
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(!q.isEmpty()){
            node temp=q.remove();
            curr.next=new ListNode(temp.val);
            curr=curr.next;
            if(temp.Node.next!=null){
                q.add(new node(temp.Node.next));
            }
        }
        return dummy.next;
    }
}