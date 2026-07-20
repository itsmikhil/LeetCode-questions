class Solution {
    // queue mai saare els daale ->1st iteration
    // fir un els ho hashmap mai daala with their rank ->2nd iteration
    // fir map se els ki rank fetch karke ans array mai daali ->3rd iteration
    // adding in pq -> logn-> n times->nlogn
    // removing from pq->logn->ntimes->nlogn
    // map get operation is const time-> n times -> n
    // total=> nlogn

    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        HashMap<Integer,Integer> map=new HashMap<>(); // el,rank
        for(int i=0;i<arr.length;i++){
            q.add(arr[i]);
        }
        int rank=1;
        while(!q.isEmpty()){
            int el=q.remove();
            if(!map.containsKey(el)){
                map.put(el,rank);
                rank++;
            }
        }
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}