class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            String str=Integer.toString(num);
            int sum=0;
            for(int i=0;i<str.length();i++){
                sum+=(str.charAt(i)-'0');
            }
            min=Math.min(sum,min);
        }
        return min;
    }
}