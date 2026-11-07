class Solution {

    // mujhe realise hogaya tha ki we need minHeap(PQ)
    // but i was thinking ki ek he PQ se kaam hojayga
    // we will first sort based on busyTillTime and then if there is a  tie 
    // then we will see its wt
    // but it will fail aage jaake
    // like at time=5
    // server1(wt=2) gets free at 4
    // server2(wt=5) gets free at 2
    // next task will be given to server 2 
    // but it should have been given to server 1

    // thats why we need 2 PQ
    // freeServers sorts based on wt
    // busyServer sorts based on busyTillTime

    class node {
        int wt, idx, busyTill;

        node(int wt, int idx, int busyTill) {
            this.wt = wt;
            this.idx = idx;
            this.busyTill = busyTill;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        int idx = 0;
        int ans[] = new int[tasks.length];
        PriorityQueue<node> freeServers = new PriorityQueue<>((a, b) -> {
            if (a.wt != b.wt) {
                return a.wt - b.wt;
            } else {
                return a.idx - b.idx;
            }
        });
        PriorityQueue<node> busyServers = new PriorityQueue<>((a, b) -> a.busyTill - b.busyTill);

        for (int i = 0; i < servers.length; i++) {
            freeServers.offer(new node(servers[i], i, 0));
        }

        int time = 0;
        while (idx < tasks.length) {

            time = Math.max(time, idx);

            // 1. Release all available servers
            while (!busyServers.isEmpty() &&
                    busyServers.peek().busyTill <= time) {

                freeServers.offer(busyServers.poll());
            }

            // 2. If nobody is free, jump time
            if (freeServers.isEmpty()) {
                time = busyServers.peek().busyTill;

                while (!busyServers.isEmpty() &&
                        busyServers.peek().busyTill <= time) {

                    freeServers.offer(busyServers.poll());
                }
            }

            // 3. Assign ONE task
            node temp = freeServers.poll();

            ans[idx] = temp.idx;
            temp.busyTill = time + tasks[idx];

            busyServers.offer(temp);

            idx++;
        }
        return ans;
    }
}