import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static String getWinner(ArrayList < String > votes) {
        HashMap<String,Integer> map=new HashMap<>();
        int max=0;
        String maxName="";
        for(String str:votes){
            map.put(str,map.getOrDefault(str,0)+1);
            int get=map.get(str);
            if(get>max){
                max=get;
                maxName=str;
            }else if(get==max && !maxName.equals(str) && str.compareTo(maxName)<0){
                maxName=str;
            }
        }
        return maxName;
    }
}