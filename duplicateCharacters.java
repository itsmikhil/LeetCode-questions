import java.util.* ;
import java.io.*; 
import java.util.*;


public class Solution {

    public static ArrayList<Pair> duplicate_char(String s, int n) {
        
        TreeMap<Character,Integer> map=new TreeMap<>();
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        ArrayList<Pair> ans=new ArrayList<>();
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                ans.add(new Pair(entry.getKey(),entry.getValue()));
            }
        }
        return ans;
    }
}