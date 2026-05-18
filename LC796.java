class Solution {
    public boolean rotateString(String s, String goal) {
        // Brute Force
        // rotated string = substring(i,till end)+substring(0,i)
        for(int i=0;i<s.length();i++){
            String check=s.substring(i)+s.substring(0,i);
            if(check.equals(goal)){
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean rotateString(String s, String goal) {
        // we will join original string twice
        // rotationrotation subtring nikalte raho original string ke length ki
        // mil jayega turant
        String check=s+s;
        for(int i=0;i<s.length();i++){
            String curr=check.substring(i,i+s.length());
            if(curr.equals(goal)){
                return true;
            }
        }
        return false;
    }
}