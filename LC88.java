class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // nums1 mai he place karo
        // lekin place karna end se start karo
        // so wahi hai merge sort wala 2 pointer approach
        // simple
        int i=m-1;
        int j=n-1;
        int k=(n+m)-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }

        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
        while(i>=0){
            nums1[k]=nums1[i];
            i--;
            k--;
        }

    }
}