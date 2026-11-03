
class Solution {
    public String minWindow(String s1, String s2) {

        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int start=-1;

        while(left<s1.length()){

            int end=-1;
            int j=0;

            // Forward traversal: find a valid subsequence
            while(left<s1.length()){

                if(s1.charAt(left)==s2.charAt(j)){
                    j++;
                }

                if(j==s2.length()){
                    end=left;
                    break;
                }

                left++;
            }

            if(end!=-1){

                // Backward traversal: minimize the window
                left=end;
                j=s2.length()-1;

                int minStart=-1;

                while(left>=0){

                    if(s1.charAt(left)==s2.charAt(j)){
                        j--;
                    }

                    if(j<0){
                        minStart=left;
                        break;
                    }

                    left--;
                }

                // Update minimum window
                if(minLen>end-minStart+1){
                    minLen=end-minStart+1;
                    start=minStart;
                }

                // Start next search after previous window's starting index
                left=minStart+1;

            }else{
                break;
            }
        }

        return start==-1 ? "" : s1.substring(start,start+minLen);
    }
}
