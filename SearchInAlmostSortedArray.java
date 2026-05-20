// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;

            // check mid
            if(arr[mid] == target){
                return mid;
            }

            // check left neighbour
            if(mid - 1 >= low && arr[mid - 1] == target){
                return mid - 1;
            }

            // check right neighbour
            if(mid + 1 <= high && arr[mid + 1] == target){
                return mid + 1;
            }

            // move right
            if(target > arr[mid]){
                low = mid + 2;
            }

            // move left
            else{
                high = mid - 2;
            }
        }

        return -1;
        
    }
}