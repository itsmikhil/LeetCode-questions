class Solution {
    int left(int x){
        return 2*x+1;
    }
    int right(int x){
        return 2*x+2;
    }
    boolean check(int arr[],int idx){
        if(idx>arr.length) return true;
        int leftIdx=left(idx);
        int rightIdx=right(idx);
        if((leftIdx<arr.length && arr[idx]<arr[leftIdx]) || (rightIdx<arr.length && arr[idx]<arr[rightIdx])){
            return false;
        }else{
            return check(arr,leftIdx) && check(arr,rightIdx);
        }
    }
    public boolean isMaxHeap(int[] arr) {
        return check(arr,0);
    }
}