class Solution {
    public int sumOfRemainder(int nums[], int divisor) {
        int sum = 0;
        double quoteint = 1;

        for (int i = 0; i < nums.length; i++) {
            quoteint = (double)nums[i] / divisor;
            sum += Math.ceil(quoteint);
        }
        
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }

        int start = 1;
        int end = max;
        int min = Integer.MAX_VALUE;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            int currSum = sumOfRemainder(nums, mid);

            if (currSum <= threshold) {
                min = mid;
                end = mid - 1;
            } else {
                
                start = mid + 1;
            }

        }

        return min;
        
    }
}