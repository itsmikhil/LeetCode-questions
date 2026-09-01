class Solution {
    
    // rowwise sorted -> BS
    // har row mai lowerBound use karke 1 ki posi find kar rahe hai
    // row ki length - firstIdxof1 -> count of 1
    
    // n*log(m)
    
    static int lowerBound(int arr[]){
        // high initially on possible case
        // after BS low will be on possible case 
        // bas wahi kiya hai
            int low=0;
            int high=arr.length-1;
            int target=1;
            while(low<=high){
                int mid=(low+high)/2;
                if(arr[mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return low;
        }
        
    public int rowWithMax1s(int[][] arr) {
        
        int count=0;
        int ansIdx=-1;
        
        for(int i=0;i<arr.length;i++){
            int currCount=arr[0].length - lowerBound(arr[i]);
            if(count<currCount){
                ansIdx=i;
                count=currCount;
            }
        }
        
        return ansIdx;
    }
};

class Solution {
    
    
        
    public int rowWithMax1s(int[][] arr) {
        
        // optimal
        // start from top right of matrix
        // if zero move down
        // if 1 move left
        // o(m+n);
        
        int i=0;
        int j=arr[0].length-1;
        int maxRowIdx=-1;
        while(i<arr.length && j>=0){
            if(arr[i][j]==1){
                maxRowIdx=i;
                j--;
            }else{
                i++;
            }
        }
        
        return maxRowIdx;
    }
}