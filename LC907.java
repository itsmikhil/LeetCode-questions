class Solution {

    // explanation on pg142
    // note 
    // findRightSmaller ya findLeftSmaller
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

    public int sumSubarrayMins(int[] arr) {
        int prevSmallerLeftIdx[]=new int[arr.length];
        int nextSmallerRightIdx[]=new int[arr.length];

        findLeftSmaller(arr,prevSmallerLeftIdx);
        findRightSmaller(arr,nextSmallerRightIdx);

        int sum=0;
        int MOD=(int)(1e9+7);
        for(int i=0;i<arr.length;i++){
            int numOfRightEls=nextSmallerRightIdx[i]-i;
            int numOfLeftEls=i-prevSmallerLeftIdx[i];

            long numOfSubarrays=(numOfRightEls)*(numOfLeftEls);
            long currSum=(numOfSubarrays*arr[i])%MOD;
            sum=(int)(sum+currSum)%MOD;
        }
        return sum;

    }
}