class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // If you are not able to decide which is the best flower in garden in one go, then take another round.
        Stack<Integer> s=new Stack<>();
        int ans[]=new int[nums.length];
        int n=nums.length;
        for(int i=2*nums.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[(i%n)]){
                s.pop();
            }
            // the first half of iterations are only used to prepare the stack, not to write answers.
            if (i < n) {
                ans[i] = s.isEmpty() ? -1 : s.peek();
            }

            s.push(nums[i%n]);
        }
        return ans;
    }
}