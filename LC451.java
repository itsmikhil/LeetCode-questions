class Solution {
    class pair{
        int count;
        char ch;
        public pair(int count,char ch){
            this.count=count;
            this.ch=ch;
        }
    }
// simple hai
// freq nikalo 
// store karo array mai aur sort karo
// then uske according string banake return
// below important point ------------------------->
    public String frequencySort(String s) {
        int freq[]=new int['z'-'0'+1];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'0']++;
        }

        pair arr[]=new pair[s.length()];
        int k=0;

        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                arr[k]=new pair(freq[i],(char)('0'+i));
                k++;
            }
        }
        // array,start idx,end idx,Lambda function
        // (a,b)->function
        // when function returns -ve a comes before b
        // when function return +ve b comes before a
        // sorting reduces time complexity
        Arrays.sort(arr,0,k,(a,b)->b.count-a.count);

        StringBuilder ans=new StringBuilder();
        for(int i=0;i<k;i++){
            for(int j=arr[i].count;j>0;j--){
                ans.append(arr[i].ch);
            }
        }

        return ans.toString();
    }
}