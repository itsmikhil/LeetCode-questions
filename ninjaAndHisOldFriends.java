import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int shakeHands(ArrayList<Integer> friends , int n, int k) {
        for(int el:friends){
            if(el==k){
                k*=2;
            }
        }
        return k;
    }
}