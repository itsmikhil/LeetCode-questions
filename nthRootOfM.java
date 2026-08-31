class Solution {
	
    // 	using long to avoid overflow
	static long findAns(int a, int b) {
		long ans = 1;
		
		for (int i = 0; i < b; i++) {
			ans *= a;
		}
		
		return ans;
	}
	
// 	simple hai
// same like squareRoot
// tc: o(logn)
	public int nthRoot(int n, int m) {
	    
	    if (m == 0) {
             return 0;
         }
		
		int start = 1;
		int end = m;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			long store = findAns(mid, n);
			
			if (store == m) {
				return mid;
			} else if (store < m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return - 1;
	}
}
