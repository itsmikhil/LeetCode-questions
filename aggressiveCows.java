class Solution {

    // Dry Run: Pg 130

    // Binary Search on Answer

    boolean isPossible(int arr[], int k, int gap) {

        // Place the first cow in the first stall.
        int prevIdx = 0;
        int count = 1;

        // Place the next cow only if the minimum required gap is maintained.
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - arr[prevIdx] >= gap) {
                prevIdx = i;
                count++;

                if (count == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public int aggressiveCows(int[] arr, int k) {

        // Sorting is mandatory.
        // We greedily place each cow in the leftmost valid stall.
        // This maximizes the chances of placing all k cows.
        Arrays.sort(arr);

        int min = arr[0];
        int max = arr[arr.length - 1];

        // Search space for the answer (minimum distance)
        int low = 1;
        int high = max - min;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // If this gap is possible,
            // try making the minimum gap even larger.
            if (isPossible(arr, k, mid)) {
                low = mid + 1;
            }
            // Gap is too large, try smaller gaps.
            else {
                high = mid - 1;
            }
        }

        // Why return high?
        //
        // We are searching for the MAXIMUM possible gap.
        //
        // Initially:
        // low  -> smallest candidate gap
        // high -> largest candidate gap
        //
        // Whenever a gap is possible,
        // we move right to search for a bigger answer.
        //
        // Whenever a gap is impossible,
        // we move left.
        //
        // After Binary Search,
        // low  points to the first impossible gap.
        // high points to the last possible gap.
        //
        // Hence, high is our answer.

        return high;
    }
}