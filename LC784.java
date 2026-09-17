class Solution {

    // Used stringBuilder to improve TC & SC
    // String hoti hai toh haar call mai new string create hoti hai -> str+"A" mai

    void makePermutation(String s,int idx,List<String> ans,StringBuilder str){
        if(idx==s.length()){
            ans.add(str.toString());
            return;
        }

        if(Character.isLowerCase(s.charAt(idx))){
            // same case mai rakho
            str.append(s.charAt(idx));
            makePermutation(s,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);

            // change case
            str.append(Character.toUpperCase(s.charAt(idx)));
            makePermutation(s,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);

        }else if(Character.isUpperCase(s.charAt(idx))){

            // same case mai rakho
            str.append(s.charAt(idx));
            makePermutation(s,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);

            // change the case
            str.append(Character.toLowerCase(s.charAt(idx)));
            makePermutation(s,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);

        }else{

            // when number is there
            str.append(s.charAt(idx));
            makePermutation(s,idx+1,ans,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();

        makePermutation(s,0,ans,new StringBuilder());

        return ans;
    }
}