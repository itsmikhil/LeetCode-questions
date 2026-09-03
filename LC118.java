class Solution {
    public List<List<Integer>> generate(int numRows) {

        // remeber this diagram
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]

        // curr state requires top left and top element 
        // if either of it is unavailable assign it as 1

        List<List<Integer>> ans=new ArrayList<>();

        List<Integer> prev=null;

        for(int i=1;i<=numRows;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<i;j++){
                
                // prev==null -> first row in making
                // j==0 -> top left not available
                // k==prev.size() -> top not available
                if(prev==null || j==0 || j==prev.size()){
                    row.add(1);
                }else{
                    row.add(prev.get(j-1)+prev.get(j));
                }
            }
            ans.add(row);
            prev=row;
        }

        return ans;
    }
}