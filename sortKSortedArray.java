class Solution {
    static String isKSortedArray(int arr[], int n, int k) {
        // Create a sorted copy of the array.
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Store ALL indices of every element in the sorted array.
        // We use a Queue because duplicate elements can occur.
        // Each occurrence should be matched with a different index.
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {
            map.putIfAbsent(sorted[i], new LinkedList<>());
            map.get(sorted[i]).offer(i);
        }

        // Compare every element's current index with its index
        // in the sorted array.
        for (int i = 0; i < arr.length; i++) {

            // Get the next available sorted position
            // for this occurrence of the element.
            int correctIndex = map.get(arr[i]).poll();

            // If an element has moved more than k positions,
            // the array is not k-sorted.
            if (Math.abs(i - correctIndex) > k) {
                return "No";
            }
        }

        return "Yes";
    }
}