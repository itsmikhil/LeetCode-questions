class minHeap {
	int size;
	ArrayList<Integer> arr;
	
	// Constructor
	public minHeap() {
		size = 0;
		arr = new ArrayList<>();
	}
	
	int parent(int x) {
		return (x - 1) / 2;
	}
	
	int left(int x) {
		return 2 * x + 1;
	}
	
	int right(int x) {
		return 2 * x + 2;
	}
	
	void swap(int a, int b) {
		int temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}
	
	public void push(int x) {
		// Insert at the end to maintain Complete Binary Tree.
		// Bubble up until the Min Heap property is restored.
		arr.add(x);
		
		int currIdx = size;
		int parentIdx = parent(currIdx);
		
		size++;
        
        // Note here we are checking currIdx>0 and not >= 
        // because otherwise it runs into a infinite loop
		while (currIdx > 0 && arr.get(parentIdx) > arr.get(currIdx)) {
			swap(currIdx, parentIdx);
			currIdx = parentIdx;
			parentIdx = parent(currIdx);
		}
	}
	
	public void pop() {
		if (size == 0)
			return;
		
		// Replace root with the last element and remove the last node.
		// Since only the root can violate the heap property,
		// we only need to bubble down.
		//
		// Note: this is not the ACTUAL NODE
		// For a general delete(index), the replaced element may need
		// either bubble up or bubble down depending on its value.
		arr.set(0, arr.get(size - 1));
		arr.remove(size - 1);
		size--;
		
		int currIdx = 0;
		
		while (true) {
			// Find the smallest among current node and its children.
			int smallest = currIdx;
			int leftIdx = left(currIdx);
			int rightIdx = right(currIdx);
			
			if (leftIdx < size && arr.get(leftIdx) < arr.get(smallest)) {
				smallest = leftIdx;
			}
			
			if (rightIdx < size && arr.get(rightIdx) < arr.get(smallest)) {
				smallest = rightIdx;
			}
			
			// If a child is smaller, swap and continue downward.
			if (smallest != currIdx) {
				swap(smallest, currIdx);
				currIdx = smallest;
			} else {
				break;
			}
		}
	}
	
	public int peek() {
		if (size == 0)
			return -1;
		return arr.get(0);
	}
	
	public int size() {
		return size;
	}
}