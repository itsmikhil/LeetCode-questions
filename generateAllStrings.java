import java.util.* ;
import java.io.*; 
public class Solution {
	static void helper(ArrayList<String> ans,String s,int idx,StringBuilder sb){
		if(idx==s.length()){
			ans.add(sb.toString());
			return;
		}
		
		// IMP
		if(s.charAt(idx)=='0') return;

		for(int i=idx;i<s.length();i++){
			String str=s.substring(idx,i+1);
			if(str.length()>9) break;
			int mapping=Integer.parseInt(s.substring(idx,i+1))-1;
			if(mapping>=0 && mapping<26){
				sb.append((char)(mapping+'a'));
				helper(ans,s,i+1,sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	public static String[] getAllStrings(String s) {
		ArrayList<String> ans=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
		helper(ans,s,0,sb);
		String arr[]=new String[ans.size()];
		int i=0;
		for(String el:ans){
			arr[i]=el;
			i++;
		}
		return arr;
	}
}