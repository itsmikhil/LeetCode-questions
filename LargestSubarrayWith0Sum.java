class Solution {
    int maxLength(int arr[]) {
        // we keep storing unique prefix sum
        // in hashmap we store (sum,index)
        // 10 5 -5
        // hashmap =>[(10,0),(15,1)]
        // i=2 => sum=10 abb hum check karte hai hashmap ki pehle bhi 10 aa chuka hai
        // matlab beech mai elements aaye hai jinka sum zero hai
        // toh wahi length= curr index - index where this sum was first seen in array
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int length=0;
        // important because maan lo currsum=0 matlab shuru se leke abhi tak ke saare elements
        // milake zero de rahe hai 
        // so length = currindex(example=5)-(-1)=>which we are storing see below
        // length=6 ===>correct
        // isliye 0,-1 store kiya tha
        map.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                length=Math.max(length,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return length;
        
    }
}