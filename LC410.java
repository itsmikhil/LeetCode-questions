class Solution {
    public int splitArray(int[] nums, int k) {

        // Same as book allocation problem

        // Lowest possible answer is the maximum element.
        // Because every subarray must contain at least one element.
        // So the largest element must be included in some subarray.
        long low = 0;

        // Highest possible answer is the sum of all elements.
        // This happens when we put all elements in one subarray.
        // So this is always a valid (possible) answer.
        long high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {

            long mid = low + (high - low) / 2;

            // Find how many subarrays are needed if
            // each subarray can have sum at most 'mid'.
            int subarrays = 1;
            long currentSum = 0;

            for (int num : nums) {

                // Current subarray cannot take this element.
                // Start a new subarray.
                if (currentSum + num > mid) {
                    subarrays++;
                    currentSum = num;
                } else {
                    currentSum += num;
                }
            }

            if (subarrays <= k) {
                // This maximum subarray sum is possible.
                // Try finding a smaller valid answer.
                high = mid - 1;
            } else {
                // More than k subarrays are required.
                // Increase the allowed maximum sum.
                low = mid + 1;
            }
        }

        // Always true in BINARY SEARCH
        // Initially:
        // low  -> impossible maximum sums
        // high -> possible maximum sums
        //
        // During binary search:
        // - If a maximum sum is possible, move left to check
        //   whether a smaller maximum sum also works.
        // - If a maximum sum is impossible, move right to
        //   increase the allowed maximum sum.
        //
        // At the end:
        // high -> last impossible maximum sum
        // low  -> first possible maximum sum (minimum answer)

        return (int) low;
    }
}