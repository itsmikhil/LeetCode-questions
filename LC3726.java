class Solution {
    public int minMoves(int[] nums) {
        int maxEl=Integer.MIN_VALUE;
        for(int el:nums){
            maxEl=Math.max(maxEl,el);
        }
        int moves=0;
        for(int el:nums){
            moves+=(maxEl-el);
        }
        return moves;
    }
}