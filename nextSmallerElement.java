class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
       Stack<Integer> s=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
       for(int i=arr.length-1;i>=0;i--){
           while(!s.isEmpty() && s.peek()>=arr[i]){
               s.pop();
           }
           list.add(s.isEmpty()?-1:s.peek());
           s.push(arr[i]);
       }
       Collections.reverse(list);
       return list; 
    }
}