class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()){
            return "0";
        }
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!s.isEmpty() && k!=0 && s.peek()>(num.charAt(i)-'0')){
                s.pop();
                k--;
            }
            s.push(num.charAt(i)-'0');
        }
        // for eg num=12345 k=3
        // upar wala while kabhi chalega he nhi 
        // isliye neeche wala while
        while(k>0){
            s.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        // important
         sb.reverse();

        // remove leading zeros
        int i = 0;
        // i is less then sb.length()-1 becuase kuch agar sab zeros ho toh bhi last wala zero return kardo
        // "0000000"=>"0"
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }

        return sb.substring(i);
    
    }
}