class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals according to starting value
        // the sorting func same as JavaScript
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Final answer stored in List of List
        List<List<Integer>> ans = new ArrayList<>();

        int n = intervals.length;

        int i = 0;

        // Traverse all intervals
        while (i < n) {

            // Current interval start
            int start = intervals[i][0];

            // Current interval end
            int end = intervals[i][1];

            int j = i + 1;

            // Keep checking next intervals
            while (j < n && intervals[j][0] <= end) {

                // Expand end if bigger end found
                end = Math.max(end, intervals[j][1]);

                j++;
            }

            // Store merged interval
            ans.add(Arrays.asList(start, end));

            // Move i to next non-overlapping interval
            i = j;
        }

        // Convert List<List<Integer>> to int[][]
        int[][] result = new int[ans.size()][2];

        for (int k = 0; k < ans.size(); k++) {
            result[k][0] = ans.get(k).get(0);
            result[k][1] = ans.get(k).get(1);
        }

        return result;
    }
}