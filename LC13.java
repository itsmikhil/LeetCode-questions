class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        int prev=-1;
        int num=0;
        for(int i=0;i<s.length();i++){
            int curr=roman.get(s.charAt(i));
            // matlab minus wala case like 9=IX
            // jisko humne by default humare number mai add kiya tha
            // isliye pehle usko subtract fir 
            // fir curr value add karo and then subtract kardo prev
            if(prev!=-1 && prev<curr){
                num-=prev;
                num+=curr;
                num-=prev;
            }else{
                num+=curr;
                prev=curr;
            }
        }
        return num;
    }
}