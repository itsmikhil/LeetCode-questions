class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        Arrays.sort(strs);
        String first=strs[0];
        String second=strs[strs.length-1];
        int n=Math.min(first.length(),second.length());
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            if(first.charAt(i)!=second.charAt(i)){
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}