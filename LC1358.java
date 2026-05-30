class Solution {
    public int numberOfSubstrings(String s) {
        // this one  is actually easy
        // optimal-> o(N) & o(3)~o(1)
        // we are tracking last seen of all 3 chars
        // jaise he teeno mil jaaye
        // hum find karte hai min possible window
        // matlab teeno char mai se sabse pehle kon dekha gaya tha
        // toh fir hum count mai utne substring add karte hai jo yaha pe KHATAM ho
        // eg:-a[bca]bc
        // jaise iske liye lastSeenArray=[3,1,2]
        // min is 1 so utne he substring possible hai jime ye sab aaye 
        // aur 'a' yaani sabse se member pe khatam ho jaaye
        int lastSeen[]=new int[3];
        int count=0;
        // we have filled -1 so thaat we can track if all chars were seen or not
        Arrays.fill(lastSeen,-1);
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                count+=(1+Math.min(Math.min(lastSeen[0],lastSeen[1]),lastSeen[2]));
            }
        }
        return count;
    }
}