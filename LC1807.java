class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // knowledge ko hash karliye
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }

        // ans string
        StringBuilder ans=new StringBuilder();

        // key ko hash mai search karni -> string between brackets
        StringBuilder keyToBeSearched=new StringBuilder();

        // agar keyChal rahi hai toh keyToBeSearched mai append hoga aur nhi toh woh ans mai direct append
        boolean keyFlag=false;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                // key chalu
                keyFlag=true;
                keyToBeSearched=new StringBuilder();
            }else if(s.charAt(i)==')'){
                // key khatam
                keyFlag=false;
                if(map.containsKey(keyToBeSearched.toString())){
                    ans.append(map.get(keyToBeSearched.toString()));
                }else{
                    ans.append("?");
                }
            }else{
                // normal chars
                if(keyFlag){
                    keyToBeSearched.append(s.charAt(i));
                }else{
                    ans.append(s.charAt(i));
                }
            }
        }
        
        return ans.toString();
    }
}