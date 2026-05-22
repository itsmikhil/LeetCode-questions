class Solution {
    // prev can be eliminated by using s.charAt(s.length()-1)
    void helper(List<String> list,int n,int prev,String a){
        if(a.length()==n){
            list.add(a);
            return;
        }
        if(prev!=0){
            // yaha a+'0' ke badle a+='0' daal diya tha
            // jiske wajah se Memory limit exceed ho rahi thi
            // kyuki a+='0' edits string for curr iteration also
            helper(list,n,0,a+'0');
        }
        helper(list,n,1,a+'1');
        return;
    }
    public List<String> validStrings(int n) {
        List<String> list=new ArrayList<>();
        // NOTE
        // if we eliminated prev using above method then we can include 
        // (s.charAt(s.length()-1)!='0' || s.isEmpty())=> in above helper function for concatinating zero condi
        helper(list,n,1,new String(""));
        return list;
    }
}