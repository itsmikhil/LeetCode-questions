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