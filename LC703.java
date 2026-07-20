class KthLargest {
    // optimal
    // Keep only the k largest elements.
    // Min Heap lets us remove the smallest element in O(log k).
    // Hence, the heap root always represents the kth largest element.
    /*
    Time Complexity:

    Constructor:
    - O(n log k)
    - We insert all n elements into the heap.
    - Each insertion takes O(log k) because the heap size never exceeds k
    (whenever size becomes k + 1, we remove one element immediately).

    add(val):
    - O(log k)
    - Insert into the heap: O(log k)
    - If heap size exceeds k, remove the smallest element: O(log k)
    - peek() is O(1)
    - Overall: O(log k)

    Space Complexity:
    - O(k)
    - The heap stores only the k largest elements at any time.
    */
    PriorityQueue<Integer> q = new PriorityQueue<>();

    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        for (int num : nums) {
            q.add(num);

            // If more than k elements are present,
            // discard the smallest one.
            if (q.size() > k)
                q.remove();
        }
    }

    public int add(int val) {
        q.add(val);

        // Maintain only the k largest elements.
        if (q.size() > k)
            q.remove();

        // Smallest among the k largest = kth largest overall.
        return q.peek();
    }
}