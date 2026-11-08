import java.util.*;
public class Solution {
    public static List<Integer> relativeSorting(List<Integer> arr, List<Integer> brr, int n, int m) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int el:arr){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        int idx=0;
        for(int i=0;i<m;i++){
            int curr=brr.get(i);
            if(map.containsKey(curr)){
                for(int j=0;j<map.get(curr);j++){
                    arr.set(idx,curr);
                    idx++;
                }
                map.remove(curr);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                arr.set(idx,entry.getKey());
                idx++;
            }
        }
        return arr;

    }
}