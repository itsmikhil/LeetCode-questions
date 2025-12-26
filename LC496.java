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

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // optimal
        // isme hum ek traversal mai sabka next greater find karke hash map mai store kar rahe hai
        // because we are assured ki all els are unique
        // fir nums1 mai traverse kar karke usse jo jo el ka next greater chaiye woh
        // hash map se uthake de dete hai
        // isliye hum O(n+m) mai kar pate hai

        Stack<Integer>  s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                map.put(nums2[i],-1);
            }else{
                map.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        
        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        
        return ans;
    }
}