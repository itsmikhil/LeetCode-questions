class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // Brute force is low se high sabke liye check karo -> n2

        // Lowest possible eating speed is 1 banana/hour.
        int low = 1;

        // Highest possible eating speed is the maximum pile.
        // Because if Koko eats at maxPile bananas/hour,
        // she can finish every pile in at most 1 hour.
        // So this speed is always a valid (possible) answer.
        int high = 0;
        for (int bananas : piles) {
            high = Math.max(high, bananas);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find total hours needed if Koko eats at 'mid' bananas/hour.
            // make it long to avoid overflow
            long hours = 0;
            for (int bananas : piles) {
                // ceil(bananas / mid)
                hours += (int)Math.ceil((double)bananas / mid);
            }

            if (hours <= h) {
                // This speed is possible.
                // Try finding a smaller valid speed.
                high = mid - 1;
            } else {
                // This speed is not enough.
                // Increase the eating speed.
                low = mid + 1;
            }
        }

        // Always true in BINARY SEARCH
        // Initially:
        // low  -> impossible speeds
        // high -> possible speeds
        //
        // During binary search:
        // - If a speed is possible, we move left to check if a smaller
        //   possible speed exists.
        // - If a speed is impossible, we move right to increase the speed.
        //
        // At the end:
        // high -> last impossible speed
        // low  -> first possible speed (minimum valid answer)

        return low;
    }
}