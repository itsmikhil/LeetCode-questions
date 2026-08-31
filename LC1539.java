class Solution {
    public int findKthPositive(int[] arr, int k) {

        // Brute Force

        // Traverse every positive number starting from 1.
        // If the current number exists in the array, skip it.
        // Otherwise, it is a missing number.
        // Count missing numbers until the kth one is found.

        // Since the array is sorted, maintain a pointer 'i'
        // to check whether the current number exists in the array.

        // TC: O(max(arr[n-1], answer))
        // (For LeetCode constraints, max value is only 1000.)

        // Auxiliary Space: O(1)

        int missingNumCount = 0;
        int i = 0;
        // arr mai values till 1000
        // but ans can be above 1000 as well
        // therefore no limit on currNum
        for (int currNum = 1; ; currNum++) {
            if (i < arr.length && currNum == arr[i]) {
                i++;
            } else {
                missingNumCount++;
                if (missingNumCount == k) {
                    return currNum;
                }
            }
        }
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {

        // code mushkil nhi hai intuition hai

        // Binary Search on Answer

        // Intuition:
        // We binary search on the array indices.
        // For every element, we calculate how many positive numbers are missing
        // before that element.
        //
        // Example:
        // arr = [2,3,4,7,11]
        //
        // arr[0] = 2
        // Positive numbers till 2 = {1,2} -> total = 2
        // Numbers present till index 0 = 1
        // Missing = 2 - 1 = 1
        //
        // arr[3] = 7
        // Positive numbers till 7 = {1...7} -> total = 7
        // Numbers present till index 3 = 4
        // Missing = 7 - 4 = 3
        //
        // General Formula:
        // Missing numbers before arr[i]
        // = arr[i] - (i + 1)
        // = arr[i] - i - 1
        //
        // Since the array is sorted,
        // missing numbers keep increasing as we move right.
        // Hence Binary Search can be applied.

        // We need the LAST index where
        // missing numbers before it < k.
        // (The answer lies after this element.)

        // Edge Case:
        // If high == -1,
        // even the first element has >= k missing numbers before it.
        // So the answer lies before arr[0].
        // Hence answer is simply k.
        //
        // Example:
        // arr = [5]
        // k = 3
        // Missing numbers = 1,2,3...
        // Answer = 3

        // Returning the answer:
        //
        // missingBeforeHigh = missing numbers before arr[high]
        //
        // We have already found 'missingBeforeHigh' missing numbers.
        // Still need:
        //
        // k - missingBeforeHigh
        //
        // more missing numbers.
        //
        // So move ahead from arr[high] by that many numbers.
        //
        // Answer:
        // arr[high] + (k - missingBeforeHigh)

        int low=0;
        int high=arr.length-1;

        while(low<=high){

            int mid= low + (high-low)/2;

            int missNums=arr[mid]-mid-1;
            if(missNums<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        if(high == -1){
            return k;
        }

        int missingBeforeHigh=arr[high]-high-1;
        
        return arr[high] + (k - missingBeforeHigh);
    }
}