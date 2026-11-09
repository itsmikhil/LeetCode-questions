import java.util.*;
public class Solution {
	public static int splitString(String s) {
		int leftUnique[]=new int[s.length()];
		HashSet<Character> set=new HashSet<>();
		for(int i=0;i<s.length();i++){
			char curr=s.charAt(i);
			set.add(curr);
			leftUnique[i]=set.size();
		}
		int rightUnique[]=new int[s.length()];
		set=new HashSet<>();
		for(int i=s.length()-1;i>=0;i--){
			char curr=s.charAt(i);
			set.add(curr);
			rightUnique[i]=set.size();
		}
		int count=0;
		for(int i=0;i<s.length()-1;i++){
			if(leftUnique[i]==rightUnique[i+1]){
				// System.out.printf("%d %d %d\n",i,leftUnique[i],rightUnique[i]);
				count++;
			}
		}

		return count;

	}
}