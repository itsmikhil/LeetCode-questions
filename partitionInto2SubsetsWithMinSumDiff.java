class Solution {
    // funda:
    // firstSubsetSum + secondSubsetSum=totalSum
   
    // matlab agar humare pass firstSubsetSum and total sum hai toh hum 
    // secondSubsetSum find kar sakte hai
    
    // "Subset sum equal to target" wala code liko
    // aur fir ye samjho ki
    // i->num of elements available for making sum from 0 to i
    // j-> targetSum that needs to be formed
    // toh hum dp array ke last row ko traverse karenge 
    // waha pe j=5 matlab 5 sum possible hai -> firstSubsetSum
    // secondSubsetSum hoga totalSum-5
    // fir hum diff find kar lenge (firstSubsetSum-secondsubsetSum)
    // aise hum har col ke liye karenge in last row 
    // aur jo bhi sabse min aayega usse return
    
    // all codes of "Subset sum equal to target" are valid
    // i have written space optimize one below
    public int minDifference(int arr[]) {
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        
        // initially zeroth row
        boolean prev[]=new boolean[totalSum+1];
        // base case that zeroSum is always possible
        // IMP
        prev[0]=true;
        // agar arr[0] is less then totalSum then woh bhi toh ek possible sum hai
        // i=0 the liye prev row hai , matalab sirf ek el available
        // yaha j=arr[0] matalb woh sum possible hai
        if(arr[0]<=totalSum){
            prev[arr[0]]=true;
        }
        
        for(int i=1;i<arr.length;i++){
            boolean curr[]=new boolean[totalSum+1];
            // base case that zeroSum is always possible
            // IMP
            curr[0]=true;
            for(int j=1;j<prev.length;j++){
                boolean notTake=prev[j];
                boolean take=false;
                if(arr[i]<=j){
                    take=prev[j-arr[i]];
                }
                curr[j]=take || notTake;
            }
            prev=curr;
        }
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<prev.length;i++){
            if(prev[i]==true){
                int firstSubsetSum=i;
                int secondSubsetSum=totalSum-firstSubsetSum;
                diff=Math.min(Math.abs(firstSubsetSum-secondSubsetSum),diff);
            }
        }
        return diff;
    }
}
