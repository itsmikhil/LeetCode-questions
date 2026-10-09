class Solution {
    public int minInsertions(String str) {
        int count=0;
        int ans=0;

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);

            // normal
            if(curr=='('){
                count++;
            }else if(curr==')'){
                // matlab '(' hai
                if(count>0){
                    // next char is ) so avail is ))
                    // valid case
                    if(i+1<str.length() && str.charAt(i+1)==')'){
                        count--;
                        i++;
                    }else{
                        // () -> case 
                        // one closing bracket missing

                        // opening bracket consume
                        count--;

                        // one closing bracket needed
                        ans++;
                    }
                
                // opening bracket not avail
                }else{
                    
                    // next char is ) , so avail is ))
                    // only opening bracket needed
                    if(i+1<str.length() && str.charAt(i+1)==')'){

                        // one opening bracket needed
                        ans++;
                        i++;
                    }else{
                        // only ) is there
                        // so one opening bracket and one closing bracket needed
                        ans++;
                        ans++;
                    }
                }
            }
        }

        // IMP 2*count
        // because for "("
        // we need to add 2 bracket thats is ))
        return ans+=(2*count);
    }
}