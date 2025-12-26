class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Brute force
        // nums1 ke haar el ke liye baar baar next greater find karo
        // iss tc is O(n*m)
        // but we want O(n+m)
        
        Stack<Integer> s;
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            s=new Stack<>();
            for(int j=nums2.length-1;j>=0;j--){
                while(!s.isEmpty() && s.peek()<nums2[j]){
                    s.pop();
                }
                if(nums1[i]==nums2[j]){
                    if(s.isEmpty()){
                        ans[i]=-1;
                        break;
                    }else{
                        System.out.println(s.peek());
                        ans[i]=s.peek();
                        break;
                    }
                }
                s.push(nums2[j]);
            }
        } 
        return ans;
    }
}

