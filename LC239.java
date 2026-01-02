class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Why Deque?
        // “In Sliding Window Maximum, we need stack-like operations while also removing elements from the front when they go 
        // out of the window. Since a stack cannot remove from the front, we use a deque.”

        // Deque mai hum incresing order(last se first) maintain karenge 
        // jo sabse first el hoga usse ans array mai add karnge

        // dry run 
        // [1,3,-1,-3,5,3,6,7], k = 3
        // deque(storing idx),ans array(storing value)
        //  for 0:- [0][] -->ans array mai tabhi he daalne shuru karenge jab i>=i-k(matlab sliding window shuru ho gayi ho)
        // for 1:-[1][] becuase 3>1 ==>apna monotonic stack type
        // for 2:-[1,2][3] we keep -1 because woh ho sakta hai aage wale window ke liye bada el ho abhi he agar usse ignore 
        // karenge toh baad mai dikaat
        // for 3:-[1,2,3][3,3] because -3 can be bigger for aage wali window isliye usse deque mai rakha
        // for 4:-[4][3,3,5] 1 ko pop kiya kyuki woh window se bahar hai purana hai 
        // 2,3 ko pop kiya kyuki woh 5 se chote hai
        // for 5:-[4,5][3,3,5,5] because 3 can be bigger for aage wala window
        // for 6:-[6][3,3,5,5,6] because 5,3 were smaller than 6
        // for 7:- [7][3,3,5,5,6,7] because 6 is smaller than 7

        // another example for dry run
        // [1,3,1,2,0,5] k=3
        // ans:-[3,3,2,5]



        if(k==1){
            return nums;
        }
        Deque<Integer> dq=new ArrayDeque<>();
        int ans[]=new int[nums.length-k+1];
        int m=0;
        for(int i=0;i<nums.length;i++){
            // window ke bahar wale idx ko hatao jo rehe gaya hai because uski value badi thi
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.removeFirst();
            }
            // chote els in window ko hatao
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
            // curr ko push karo irrespective of woh chota hai ya bada because he might be bigger for upcoming windows
            dq.addLast(i);
            // array mai aad karna k-1 se start karo because wahi se window start hogi first wali
            if(i>=k-1){
                ans[m]=nums[dq.peekFirst()];
                m++;
            }
        }
        return ans;
    }
}