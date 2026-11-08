import java.util.*;

public class Solution {
    public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            char ch=ptr.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        int left=0;
        int count=0;
        for(int right=0;right<n;right++){
            char curr=str.charAt(right);
            if(map.containsKey(curr)){
                int get=map.get(curr);
                if(get>0){
                    count++;
                }
                map.put(curr,get-1);
                
            }
            if(right-left+1>m){
                char remove=str.charAt(left);
                if(map.containsKey(remove)){
                    int get=map.get(remove);
                    if(get>=0){
                        count--;
                    }
                    map.put(remove,get+1);
                }
                left++;
            }
            if(right-left+1==m && count==m){
                list.add(left);
            }
        }
        return list;
    }
}