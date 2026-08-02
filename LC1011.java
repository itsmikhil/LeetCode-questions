class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // Similar to koko

        // Lowest possible capacity is the maximum weight.
        // Because every package must fit into the ship.
        // If capacity is less than the heaviest package,
        // that package can never be shipped.
        int low = 0;

        // Highest possible capacity is the sum of all weights.
        // Because with this capacity, we can carry every package
        // in a single day. So this is always a valid (possible) answer.
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find how many days are needed if ship capacity is 'mid'.
            int requiredDays = 1;
            int currentLoad = 0;

            for (int weight : weights) {

                // If current package exceeds today's remaining capacity,
                // ship it on the next day.
                if (currentLoad + weight > mid) {
                    requiredDays++;
                    currentLoad = weight;
                } else {
                    currentLoad += weight;
                }
            }

            if (requiredDays <= days) {
                // This capacity is possible.
                // Try finding a smaller valid capacity.
                high = mid - 1;
            } else {
                // This capacity is not enough.
                // Increase the ship capacity.
                low = mid + 1;
            }
        }

        // Always true in BINARY SEARCH
        // Initially:
        // low  -> impossible capacities
        // high -> possible capacities
        //
        // During binary search:
        // - If a capacity is possible, move left to check whether
        //   a smaller capacity also works.
        // - If a capacity is impossible, move right to increase
        //   the ship capacity.
        //
        // At the end:
        // high -> last impossible capacity
        // low  -> first possible capacity (minimum valid answer)

        return low;
    }
}