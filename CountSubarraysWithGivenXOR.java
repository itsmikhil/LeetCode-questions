class Solution {
    public long subarrayXor(int arr[], int k) {
        // similar to prev question Largest Subarray with Sum 0
        // the optimal approach is also same as it
        // this is also prefix approach
        // here instead of sum we are storing xor
        // maths:-
        // a=b^k
        // a=abb tak ka xor
        // b=wo hissa jisko hatane se woh hume goal milega
        // k=required result
        // now we know a^a=0 and a^0=a
        // similarly
        // a^k=b^k^k ====> a^k=b
        // isliye curr xor ko goal se xor karte hai toh find hatane wala hissa
        // aur agar woh mil jaye hashmap toh count ko add kar dete hai
        // note :- we keep track ki konsa xor kitni baar aaya so that we can add that much to count
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int xor=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(map.containsKey(xor^k)){
                count+=map.get(xor^k);
            }
            if(map.containsKey(xor)){
                map.put(xor,map.get(xor)+1);
            }else{
                map.put(xor,1);
            }
        }
        return count;
        
    }
}