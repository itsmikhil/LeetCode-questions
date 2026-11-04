class Solution {

    // explanation on pg142
    // note

    // SUM OF SUBARRAY RANGES
    // = SUM OF SUBARRAY MAXIMUMS - SUM OF SUBARRAY MINIMUMS
    //
    // arr = [1, 3, 2]
    //
    // Subarrays:       Max - Min
    // [1]                1 - 1 = 0
    // [3]                3 - 3 = 0
    // [2]                2 - 2 = 0
    // [1,3]              3 - 1 = 2
    // [3,2]              3 - 2 = 1
    // [1,3,2]            3 - 1 = 2
    //
    // Sum of ranges = 0 + 0 + 0 + 2 + 1 + 2 = 5
    //
    // Sum of maximums = 1 + 3 + 2 + 3 + 3 + 3 = 15
    // Sum of minimums = 1 + 3 + 2 + 1 + 2 + 1 = 10
    //
    // Therefore: 15 - 10 = 5

    // kisi ek mai > ko >= karo
    // to tackle repeating nums

    void findRightSmaller(int arr[], int nextSmallerRightIdx[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]>=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmallerRightIdx[i]=n;
            }else{
                nextSmallerRightIdx[i]=s.peek();
            }
            s.push(i);
        }
    }

    void findLeftSmaller(int arr[], int prevSmallerLeftIdx[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]>curr){
                s.pop();
            }
            if(s.isEmpty()){
                prevSmallerLeftIdx[i]=-1;
            }else{
                prevSmallerLeftIdx[i]=s.peek();
            }
            s.push(i);
        }
    }

    void findRightGreater(int arr[], int nextGreaterRightIdx[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]<=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreaterRightIdx[i]=n;
            }else{
                nextGreaterRightIdx[i]=s.peek();
            }
            s.push(i);
        }
    }

    void findLeftGreater(int arr[], int prevGreaterLeftIdx[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!s.isEmpty() && arr[s.peek()]<curr){
                s.pop();
            }
            if(s.isEmpty()){
                prevGreaterLeftIdx[i]=-1;
            }else{
                prevGreaterLeftIdx[i]=s.peek();
            }
            s.push(i);
        }
    }

    long sumSubarrayMins(int[] arr) {
        int prevSmallerLeftIdx[]=new int[arr.length];
        int nextSmallerRightIdx[]=new int[arr.length];

        findLeftSmaller(arr,prevSmallerLeftIdx);
        findRightSmaller(arr,nextSmallerRightIdx);

        long sum=0;

        for(int i=0;i<arr.length;i++){
            int numOfRightEls=nextSmallerRightIdx[i]-i;
            int numOfLeftEls=i-prevSmallerLeftIdx[i];

            long numOfSubarrays=(long)numOfRightEls*numOfLeftEls;
            long currSum=numOfSubarrays*arr[i];

            sum+=currSum;
        }
        return sum;
    }

    long sumSubarrayMaxs(int[] arr) {
        int prevGreaterLeftIdx[]=new int[arr.length];
        int nextGreaterRightIdx[]=new int[arr.length];

        findLeftGreater(arr,prevGreaterLeftIdx);
        findRightGreater(arr,nextGreaterRightIdx);

        long sum=0;

        for(int i=0;i<arr.length;i++){
            int numOfRightEls=nextGreaterRightIdx[i]-i;
            int numOfLeftEls=i-prevGreaterLeftIdx[i];

            long numOfSubarrays=(long)numOfRightEls*numOfLeftEls;
            long currSum=numOfSubarrays*arr[i];

            sum+=currSum;
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {

        // SUM OF SUBARRAY RANGES
        // = SUM OF SUBARRAY MAXIMUMS - SUM OF SUBARRAY MINIMUMS

        long sumOfSubarrayMaxs=sumSubarrayMaxs(nums);
        long sumOfSubarrayMins=sumSubarrayMins(nums);

        return sumOfSubarrayMaxs-sumOfSubarrayMins;
    }
}