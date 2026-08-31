class Solution {

    // note flowers should be adjacent to make a bouquet

    // i was over complicating this check func which is actually very simple
    // i was using a boolean taken[] array which was not at all needed
    // NOTE CHECK FUNC ALSO
    // how simply its written

    // tc: Binary Search: O(log(maxBloomDay))
    // each check(): O(n)
    // overall o(n * log(maxBloomDay))
    boolean check(int arr[], int m, int k, int currDay) {

        int flowers = 0;
        int bouquets = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] <= currDay) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        // if we dont have enough num of flowers then return -1
        if (m * k > bloomDay.length) {
            return -1;
        }

        // min 1 day
        int low = 1;

        // max will be greatest blooming day
        int high = 0;
        for (int el : bloomDay) {
            high = Math.max(el, high);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // check for mid if its possible
            boolean possible = check(bloomDay, m, k, mid);

            // if it is possible store it as ans
            // and check for smaller
            if (possible) {
                ans = mid;
                high = mid - 1;
                // if not possible try increasing 
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}