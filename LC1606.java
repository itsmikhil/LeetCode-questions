// Intuition in LC1267
class Solution {

    class node {
        int idx;
        long busyTill;
        int numOfRequestServed;

        node(int idx, long busyTill, int numOfRequestServed) {
            this.idx = idx;
            this.busyTill = busyTill;
            this.numOfRequestServed = numOfRequestServed;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        // Initially I thought of using a minHeap for freeServers.
        // But PriorityQueue only gives us the smallest available server.
        // The question requires us to find the smallest available server
        // >= (i % k), and if none exists, wrap around to the smallest ID.
        // Hence, we use TreeSet because it supports ceiling() and first().

        TreeSet<node> freeServers = new TreeSet<>((a, b) -> {
            return Integer.compare(a.idx, b.idx);
        });

        // MinHeap based on busyTill.
        // Stores servers currently processing requests.
        // The server that becomes free earliest will be at the top.
        PriorityQueue<node> busyServers = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.busyTill, b.busyTill);
        });

        int count[] = new int[k];

        // Initially all servers are free.
        for(int i = 0; i < k; i++) {
            freeServers.add(new node(i, 0, 0));
        }

        for(int i = 0; i < arrival.length; i++) {

            long time = arrival[i];

            // Release all servers whose processing has finished.
            // <= because a server finishing exactly at arrival time
            // is also available for the current request.
            while(!busyServers.isEmpty() &&
                  busyServers.peek().busyTill <= time) {

                node temp = busyServers.poll();
                freeServers.add(temp);
            }

            // If no server is free, drop this request.
            if(freeServers.isEmpty()) {
                continue;
            }

            // According to the question, we start searching from i % k.
            int start = i % k;

            // ceiling() returns the smallest available server ID
            // which is >= start.
            // Our comparator compares nodes only by idx.
            node key = new node(start, 0, 0);

            node server = freeServers.ceiling(key);

            // If ceiling() returns null, it means there is no available
            // server >= start.
            // So we wrap around and select the smallest available ID.
            if(server == null) {
                server = freeServers.first();
            }

            // Remove the selected server from freeServers
            // because it is now going to handle a request.
            freeServers.remove(server);

            server.numOfRequestServed++;

            // Update when this server will become free.
            server.busyTill = time + load[i];

            count[server.idx]++;

            // Move this server into the busyServers minHeap.
            busyServers.offer(server);
        }

        // Find the maximum number of requests handled by any server.
        int max = 0;

        for(int x : count) {
            max = Math.max(max, x);
        }

        // Collect all servers having the maximum request count.
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            if(count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
