class Solution {

    // memoization
    // tc: o(n*n *n) -> n*n -> matrix and n->for loop that we run in each call
    // sc: o(n*n) + o(n)(rec stack space) 
    
    int helper(ArrayList<Integer> cuts,int dp[][],int left,int right){
        // left aur right toh boundary uske beech wale main hai
        // sir boundary aur beech ke els he nhi hai matlab invalid
        if(right-left==1) return 0;

        // already calc
        if(dp[left][right]!=-1) return dp[left][right];

        // finding len
        int len=cuts.get(right)-cuts.get(left);

        int min=Integer.MAX_VALUE;

        // left and right is just boundary 
        // the cut els are in between 
        for(int index=left+1;index<=right-1;index++){
            int cost=len+helper(cuts,dp,left,index)+helper(cuts,dp,index,right);
            min=Math.min(min,cost);
        }

        // return ans
        return dp[left][right]=min;
    }
    public int minCost(int n, int[] cuts) {
        
        // sorting is very IMP  
        Arrays.sort(cuts);
        
        // cuts.length+2 because we add 0 and n in arraylist below
        int dp[][] = new int[cuts.length + 2][cuts.length + 2];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        // add 0 and n because they help fidning len of stick getting cut
        ArrayList<Integer> cut=new ArrayList<>();
        cut.add(0);
        for(int el:cuts){
            cut.add(el);
        }
        cut.add(n);

        // note 0 to cut.size()-1
        return helper(cut,dp,0,cut.size()-1);
    }
}