class Solution {

    // Recursion(Backtracking) 
    // can be solved with dp as well
    // this is the literal intuition
    // link : https://assets.leetcode.com/users/images/b6f5ade4-d5b8-445e-8ee9-e16a0d4f2292_1711522213.8992066.png
    
    // VIMP
    // TC: O(N * 2^N)
    // For a string of N characters, there are N-1 gaps:
    // _a_b_c_d_
    // Each gap has 2 choices → cut or no cut.
    // Therefore, total possible partitions = 2^(N-1) ≈ 2^N.
    // For each partition, O(N) work may be needed for palindrome checking/substrings.

    boolean isPalindrome(String s,int start,int end){
        int i=start;
        int j=end;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    void makePartition(String s,int idx,List<List<String>> ans,List<String> str){
        
        if(idx==s.length()){
            ans.add(new ArrayList<>(str));
            return;
        }

        for(int i=idx;i<s.length();i++){

            if(isPalindrome(s,idx,i)){
                str.add(s.substring(idx,i+1));
                makePartition(s,i+1,ans,str);
                str.remove(str.size()-1);
            }

        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> str=new ArrayList<>();
        makePartition(s,0,ans,str);
        return ans;
    }
}