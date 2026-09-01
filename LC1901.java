class Solution {

    // Dry Run -> Pg 131

    // Returns the column index of the maximum element in a row.
    // Since the peak in a row can only occur at its maximum element,
    // we first locate the largest element in the current row.
    int findMaxElIdx(int[] arr) {

        int max = arr[0];
        int maxIdx = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }

    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // Binary Search on Rows
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find the maximum element in the middle row.
            // If a peak exists in this row, it has to be this element,
            // because it is already greater than its left and right neighbours.
            int maxCol = findMaxElIdx(mat[mid]);

            // Values just above and below the current element.
            // If we're on the boundary, assume -1 (given all matrix values are positive).
            int up = (mid == 0) ? -1 : mat[mid - 1][maxCol];
            int down = (mid == n - 1) ? -1 : mat[mid + 1][maxCol];

            // Peak Condition:
            // Current element is greater than both its vertical neighbours.
            // It is already greater than left & right because it is the
            // maximum element in its row.
            if (mat[mid][maxCol] > up && mat[mid][maxCol] > down) {
                return new int[] { mid, maxCol };
            }

            // If the upper neighbour is greater,
            // then a peak definitely exists in the upper half.
            else if (up > mat[mid][maxCol]) {
                high = mid - 1;
            }

            // Otherwise the lower neighbour is greater,
            // so a peak must exist in the lower half.
            else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }
}