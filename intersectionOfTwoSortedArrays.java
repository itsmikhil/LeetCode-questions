class Solution {
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        int i=0;
        int j=0;
        ArrayList<Integer> ans=new ArrayList<>();
        
        // increment i and j such that it is not same as prev el
        // warna repetition ho jayega ans array mai
        
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]==arr2[j]){
                ans.add(arr1[i]);
                i++;
                while(i<arr1.length && arr1[i]==arr1[i-1]){
                    i++;
                }
                j++;
                while(j<arr2.length && arr2[j]==arr2[j-1]){
                    j++;
                }
            }else if(arr1[i]>arr2[j]){
                 j++;
                while(j<arr2.length && arr2[j]==arr2[j-1]){
                    j++;
                }
            }else{
                i++;
                while(i<arr1.length && arr1[i]==arr1[i-1]){
                    i++;
                }
            }
        }
        return ans;
        
    }
}
