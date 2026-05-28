// brute force with hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==1){
            return 1;
        }
        int max=0;
        int i=0;
        int j=0;
        int flg=0;
        HashMap<Character,Integer> map;
        for(i=0;i<s.length();i++){
            map=new HashMap<>();
            flg=0;
            for(j=i;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    max=Math.max(max,j-i);
                    flg=1;
                    break;
                }
                map.put(s.charAt(j),1);
            }
            // what if curr character se end tak koyi duplicate nhi milta(because in above loop i am updating max only when duplicate is encountered )
            if(flg==0){
                max=Math.max(max,j-i);
            }
        }
        return max;
    }
}

// optimal:-
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // left and right pointer => both start from 0
        // abcdabcde
        // keep moving right and and storing index of chracters
        // here eg:- left=0 right=4 hashMap={(a,0),(b,1),(c,2),(d,3)}
        // when we check for 'a'(index 4) we get to knwo that humaru window mai already ek 'a' hai
        // because jab hum uska index fetc karte hai hashmap toh index >=left milta hai matlab humari window mai hai
        // isliye hum hume woh repaeated element ko hatana hai
        // isliye hum left=hashmap se jo index mila hai plus 1 pe move kar dete hai 
        // here left moved to 1(because prev 'a' was on index 0 so, 0+1)
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<s.length()){
            int get=map.getOrDefault(s.charAt(right),-1);
            if(get!=-1){
                // should be >= because what if left pointer wala el ge repated ho
                if(get>=left){
                    left=get+1;
                }
            }
            max=Math.max(max,right-left+1);
            map.put(s.charAt(right),right);
            right++;
        }
        return max;
    }
}