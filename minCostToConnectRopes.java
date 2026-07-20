class Solution {
    public static int minCost(int[] arr) {
        // min heap
        // queue se do do karke smallest el nikalte raho
        // unka effort add karke wapas queue mai daal do
        // aur har connection ke effort ko ans mai add karte raho
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        int sum=0;
        while(q.size()>1){
            int effort=q.poll()+q.poll();
            q.offer(effort);
            sum+=effort;
        }
        return sum;
    }
}