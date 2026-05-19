class Solution {
    public static int countSubstring(String s) {
        // we are storing last seen index of a,b,c in array
        // maan lo kahi pe point aaya jaha pe sab ek ek baar aa chuke hai 
        // iska matalb ye hota hai uss point tak jitne bhi substring END ho rahe hai
        // sab valid hai
        // eg aabcaaa
        // for i=3 freq=[1,2,3]
        // iss point ye sab != -1 hue
        // matlab yaha par khatam hone wale saare substring jaise aabc, abc ye sab valid hai
        // iska count => 1 + Math.min(all 3 in array)
        // bass wahi kiya hai
        int lastSeen[]=new int[3];
        Arrays.fill(lastSeen,-1);
        int count=0;
        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a']=i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                count+=(1+Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return count;
    }
}
