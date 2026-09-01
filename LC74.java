class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // better (wahi staircase waka tareeka) 
        // o(n+m) -> but this tc is not allowed
        // int i=0;
        // int j = matrix[0].length - 1;
        // while(i<matrix.length && j>=0){
        //     if(matrix[i][j]==target){
        //         return true;
        //     }else if(matrix[i][j]<target){
        //         i++;
        //     }else if(matrix[i][j]>target){
        //         j--;
        //     }
        // }
        // return false;

        // optimal
        // abhi matrix sorted 
        // matrix ko flat kardo -> 1d bana do
        // aur normal BS lagao
        // aur fir uske baad row aur col find karlo
        // mid ki val ko 2d coordinate mai convert
        // row=(mid)/m;
        // col=(mid)%m;

        // tc: log(n*m)

        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high= n*m -1;

        while(low<=high){
            int mid=(low+high)/2;

            int row=(mid)/m;
            int col=(mid)%m;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;



    }
}