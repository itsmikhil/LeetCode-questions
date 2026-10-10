class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        // Basic intuition:
        // 1. Create a diff array storing the absolute difference
        //    between corresponding elements of nums1 and nums2.
        // 2. We need to minimize the sum of squared differences.
        // 3. Greedily apply -1 operations to the largest differences first.
        // 4. Total available operations = k1 + k2.

        // Idea 1: Max Heap (PriorityQueue)
        // - Store all absolute differences in a max heap.
        // - In every operation, remove the maximum difference,
        //   decrease it by 1, and insert it back if it is positive.
        // - This gives TLE when k1 + k2 is very large because
        //   we perform one heap operation for every available operation.

        // Idea 2: Frequency Array (Optimized)
        // - Instead of storing every difference individually,
        //   store the frequency of each possible difference.
        // - For example, if difference 4 occurs 3 times,
        //   diff[4] = 3.
        // - We can reduce all three occurrences of 4 to 3 together,
        //   instead of processing them individually.
        // - Since nums[i] <= 100000, the maximum difference is 100000.

        int[] diff = new int[(int) 1e5 + 1];

        // Count the frequency of every absolute difference.
        for (int i = 0; i < nums1.length; i++) {
            diff[Math.abs(nums1[i] - nums2[i])]++;
        }

        // Total number of operations available from both arrays.
        int k = k1 + k2;

        // Start from the maximum possible difference and move downward.
        // We process the largest differences first to minimize
        // the sum of squared differences.
        for (int i = (int) 1e5; i >= 1 && k > 0; i--) {

            // If this difference occurs at least once,
            // we can reduce some or all of its occurrences by 1.
            if (diff[i] != 0) {

                // Number of operations we can perform at this level:
                // - If occurrences > available operations, use all operations.
                // - Otherwise, reduce every occurrence at this level.
                int possibleOperations = Math.min(diff[i], k);

                // These differences decrease from i to i - 1.
                diff[i] -= possibleOperations;
                diff[i - 1] += possibleOperations;

                // Update the number of remaining operations.
                k -= possibleOperations;
            }
        }

        // Calculate the final sum of squared differences.
        long ans = 0;

        for (int i = (int) 1e5; i >= 1; i--) {

            // Frequency × (difference squared).
            // Use 1L to prevent integer overflow during multiplication.
            if (diff[i] != 0) {
                ans += 1L * diff[i] * i * i;
            }
        }

        return ans;
    }
}