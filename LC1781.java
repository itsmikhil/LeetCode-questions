class Solution {
    public int beautySum(String s) {
        // simple brute force
        // haar substring ke liye hashmap mai values update karo aur max aur min find karke diff nikalake add kardo
        // understand edge case like "a"
        // mini = Math.min(2147483647, 1) = 1
        // maxi = Math.max(-2147483648, 1) = 1 
        // isliye beauty=0
        int n = s.length();
        int sum = 0;

        // Loop through all substrings
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freq = new HashMap<>();
            // hum ye inner loop ko i se run kara rahe hai kyuki hume count updates rakhna hai hash mai
            // warna single length substring ka toh beauty waise he zero hoga
            for (int j = i; j < n; j++) {
                // Increase character frequency
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                // Calculate max and min frequency
                for (int val : freq.values()) {
                    mini = Math.min(mini, val);
                    maxi = Math.max(maxi, val);
                }

                // Add to sum
                sum += (maxi - mini);
            }
        }

        return sum;
    }
}