class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        // brute -> o(n*(n+m))
        int minLen=Integer.MAX_VALUE;
        int startIdx=-1;
        for(int i=0;i<s.length();i++){
            // jo jo els 't' mai sabko hashmap mai store karo
            // character,freq
            HashMap<Character,Integer> map=new HashMap<>();
            for(int j=0;j<t.length();j++){
                map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0)+1);
            }
            // jitne characters humari window mai aa chuke hai uske liye -> variable count
            int count=0;
            for(int j=i;j<s.length();j++){
                // if we find that character inside the hashmap
                // we decrment the count in hashMap 
                // and incremnet the count var
                int val=map.getOrDefault(s.charAt(j),-1);
                if(val>0){
                    map.put(s.charAt(j),val-1);
                    count++;
                }
                // once count=t.length() means we have found all els 
                // so we update minLen and startIdx if needed
                if(count==t.length()){
                    if(minLen>(j-i+1)){
                        minLen=j-i+1;
                        startIdx=i;
                        break;
                    }
                }
            }
        }
        // all els were never found
        if(startIdx==-1){
            return "";
        }
        return s.substring(startIdx,startIdx+minLen);
    }
}
class Solution {
    public String minWindow(String s, String t) {
        // invalid case
        if(s.length()<t.length()){
            return "";
        }

        // optimal -> o(n+m)
        // brute dekh ke aana wahi se derive kiya hai
        int minLen=Integer.MAX_VALUE;
        int startIdx=-1;
        int left=0;
        int right=0;

        // store all target els in hashmap
        // character,freq
        HashMap<Character,Integer> map=new HashMap<>();
        for(int j=0;j<t.length();j++){
            map.put(t.charAt(j),map.getOrDefault(t.charAt(j),0)+1);
        }

        // count increments for each target char we have in our curr window
        int count=0;

        while(right<s.length()){

            // decrease freq as current char enters the window
            if(map.containsKey(s.charAt(right))){
                int val=map.get(s.charAt(right));

                // char target list mai hai AND abhi bhi uski requirement baki hai
                // aur uski val>0 matlab usko include karna baaki tha
                // toh abhi mark karenge ki woh window mai aa chuka hai
                if(val>0){
                    count++;
                }

                map.put(s.charAt(right),val-1);
            }

            // jaisa he pehle valid case aaye
            // we move "left" pointer so that sabse minLen case mile
            if(count==t.length()){

                while(count==t.length()){

                    // update val
                    if((right-left+1)<minLen){
                        minLen=right-left+1;
                        startIdx=left;
                    }

                    // jisko nikala agar woh target char hai woh uski val wapas se ++ karo
                    // kya pata hume sirf 2 a's chaiye the
                    // lekin hum 3 leke baithe hai
                    if(map.containsKey(s.charAt(left))){
                        int val=map.get(s.charAt(left));

                        map.put(s.charAt(left),val+1);

                        // jaise target el ki freq min requiremet se kum ho jaye then count--
                        // fir wapas loop break karke window expand karna shuru
                        if(val+1>0){
                            count--;
                        }
                    }

                    left++;
                }
            }

            right++;
        }

        // no valid string found
        if(startIdx==-1){
            return "";
        }

        // return ans
        return s.substring(startIdx,startIdx+minLen);
    }
}