
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,int need1, int need2) {
        // was thinking of DP
        // but greedy is optimal solution for this
        // because of ATLEAST case
        // i have written DP code and is attached below

        // option1
        // need1 by cost1  && need2 by cost2
        long option1=1L*cost1*need1 + 1L*cost2*need2;

        // option2
        // common wala part costBoth se && uncommon wala part cost1,cost2
        int common=Math.min(need1,need2);
        long option2=1L*costBoth*common + 1L*(need1-common)*cost1 + 1L*(need2-common)*cost2;

        // option3
        // saare kuch he costBoth se
        // iske chakar mai agar need1 or need2 negative ho bhi gaya toh no issue
        int bigger=Math.max(need1,need2);
        long option3= 1L*costBoth*bigger;

        return Math.min(option1,Math.min(option2,option3));
    }
}

// class Solution {
        // gives memory limit exceeded
//     // Memoization
//     // ATLEAST CONDITION-> IMP
//     // HOW DID WE HANDLE NEGATIVE IDX IN DP ARRAY -> IMP
//     long helper(long dp[][], int cost1, int cost2, int costBoth, int need1, int need2) {

//         // Both requirements are fulfilled.
//         // We need not buy anything more.
//         if (need1 <= 0 && need2 <= 0) {
//             return 0;
//         }

//         // Requirements can become negative because we need
//         // AT LEAST need1 and need2 units.
//         // Extra contributions are allowed.
//         // Convert negative requirements to 0 to avoid
//         // negative DP indices.
//         need1 = Math.max(0, need1);
//         need2 = Math.max(0, need2);

//         if (dp[need1][need2] != -1) {
//             return dp[need1][need2];
//         }

//         // Buy type 1: satisfies only type 1 requirement.
//         long type1 = Long.MAX_VALUE;
//         if (need1 > 0) {
//             type1 = cost1 + helper(dp, cost1, cost2, costBoth, need1 - 1, need2);
//         }

//         // Buy type 2: satisfies only type 2 requirement.
//         long type2 = Long.MAX_VALUE;
//         if (need2 > 0) {
//             type2 = cost2 + helper(dp, cost1, cost2, costBoth, need1, need2 - 1);
//         }

//         // Buy type 3: satisfies BOTH requirements.
//         // Even if one requirement becomes negative,
//         // the extra contribution is allowed.
//         long type3 = costBoth + helper(dp, cost1, cost2, costBoth, need1 - 1, need2 - 1);

//         return dp[need1][need2] = Math.min(type1, Math.min(type2, type3));
//     }

//     public long minimumCost(int cost1, int cost2, int costBoth,int need1, int need2) {

//         long dp[][] = new long[need1 + 1][need2 + 1];

//         for (int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return helper(dp, cost1, cost2, costBoth, need1, need2);
//     }
// }


