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