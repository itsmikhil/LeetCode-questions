class Solution {
    // better
    // memoization
    // top down
    // tc: o(n*3)-> n days 3 activity -> size of matrix
    // sc:o(n)(stack)+o(n2)(dp array)
    int helper(int mat[][],int dp[][],int day,int prev){
        // overlapping subproblem
        // Return the stored answer if this state is already computed.
        if(dp[day][prev] != -1)return dp[day][prev];
        
        // if its the last day just find max and return because there 
        // will be no further calls as this is the last day
        if(day==0){
            int max=Integer.MIN_VALUE;
            int maxIdx=-1;
            for(int i=0;i<mat[0].length;i++){
                if(i!=prev){
                    if(max<mat[day][i]){
                        max=mat[day][i];
                        maxIdx=i;
                    }
                }
            }
            return dp[day][prev]=max;
        }else{
            // try all possible combinations
            // I letting you pick any other activity other then prev
            // just pick and give me the toal by making recursive calls
            int max=Integer.MIN_VALUE;
            int maxIdx=-1;
            for(int i=0;i<mat[0].length;i++){
                if(i!=prev){
                    int activity=mat[day][i]+helper(mat,dp,day-1,i);
                    max=Math.max(max,activity);
                }
            }
            return dp[day][prev]=max;
        }
    }
    public int maximumPoints(int mat[][]) {
        // a extra col is added as it is the point from where we will start function
        // initially we cannot mark any of the activity to be taken isliye ek extra col banaya hia
        // agar -1 use karenge toh upaar code mai dp array ko iss idx se access karne mai issue hoga
        // dp[day][prev]
        // prev = 0,1,2 -> previously chosen activity
        // prev = 3 -> no previous activity (initial state)
       int dp[][] = new int[mat.length][4]; // day,previously taken activity

       for(int[] row : dp)
           Arrays.fill(row, -1);
       
        
       return helper(mat,dp,mat.length-1,3);
    }
}
class Solution {
	// optimal
	// bottom up
	// memoization le dekh ke ye code likhunga
	// as it is memoization ka code isme transfer karo
	// isme ko 3rd col hai woh extra hai
	// woh memoization mai use hota hai
	// tabulation mai toh because hume usse bass resuse karna hai isliye bass
	// usse carry forward kar rahe hai
	
	public int maximumPoints(int mat[][]) {
		int n = mat.length;
		int[][] dp = new int[n][4];
		
		// If previous activity was 0,
		// we can choose only 1 or 2 today.
		dp[0][0] = Math.max(mat[0][1], mat[0][2]);
		
		// If previous activity was 1,
		// we can choose only 0 or 2 today.
		dp[0][1] = Math.max(mat[0][0], mat[0][2]);
		
		// If previous activity was 2,
		// we can choose only 0 or 1 today.
		dp[0][2] = Math.max(mat[0][0], mat[0][1]);
		
		// No previous activity (starting state)
		dp[0][3] = Math.max(mat[0][0],
		Math.max(mat[0][1], mat[0][2]));
		
		for (int day = 1; day < n; day++) {
			
			// prev = activity performed on previous day
			for (int prev = 0; prev < 4; prev++) {
				
				dp[day][prev] = Integer.MIN_VALUE;
				
				// Try every activity for current day
				for (int activity = 0; activity < 3; activity++) {
					
					if (activity != prev) {
						
						dp[day][prev] = Math.max(
						dp[day][prev],
						mat[day][activity] + dp[day - 1][activity]
						);
					}
				}
			}
		}
		// Initial state -> no previous activity
		return dp[n - 1][3];
	}
}