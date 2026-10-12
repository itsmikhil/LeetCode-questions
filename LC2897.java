
class Solution {
    public int maxSum(List<Integer> nums, int k) {

        // mushkil nhi hai
        // bass samjho 

        // INTUITION:
        // We are given AND and OR operations, but we don't need
        // to actually perform them on the original numbers.
        //
        // The key observation is that these operations can
        // redistribute set bits among numbers without changing
        // the total sum.
        //
        // So, instead of working with the original numbers,
        // we count how many times each bit is set.
        //
        // setBitCount[i] = number of occurrences of the ith bit.

        int setBitCount[] = new int[32];

        // STEP 1: Count the set bits at every bit position.
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < 32; j++) {

                // Check whether the jth bit is set in this number.
                if ((nums.get(i) & (1 << j)) != 0) {
                    setBitCount[j]++;
                }
            }
        }

        int MOD = 1000000007;
        long ans = 0;

        // STEP 2: Construct k numbers using the available set bits.
        // We try to make each number as large as possible,
        // because a larger number contributes more to the sum of squares.

        while (k > 0) {
            int num = 0;

            for (int i = 0; i < 32; i++) {

                // If this bit is available, include it in the current number.
                if (setBitCount[i] > 0) {

                    // Set the ith bit in the current number.
                    num = num | (1 << i);

                    // We have used one occurrence of this bit.
                    // It cannot be used again unless another occurrence exists.
                    setBitCount[i]--;
                }
            }

            // Add the square of the current number to the answer.
            ans = (ans + (long) num * num) % MOD;

            // Construct the next number.
            k--;
        }

        return (int) ans;
    }
}
