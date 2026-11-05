import java.util.* ;
import java.io.*; 
public class Solution
{
	public static ArrayList<Integer> prevSmall(ArrayList<Integer> arr, int n)
	{
		// next smaller on left
		Stack<Integer> s=new Stack<>();
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<arr.size();i++){
			int curr=arr.get(i);
			while(!s.isEmpty() && arr.get(s.peek())>=curr){
				s.pop();
			}
			if(s.isEmpty()){
				ans.add(-1);
			}else{
				ans.add(arr.get(s.peek()));
			}
			s.add(i);
		}
		return ans;
	}
}
