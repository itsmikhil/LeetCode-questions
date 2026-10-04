class Solution {
    public boolean canTransform(int[] source, int[] target) {
        // we note that 
        // source[i] = source[i] + source[j] - delta
        // source[j] = delta
        // so source[i]+source[j]==source[i]+source[j]
        // so there sum remians same
        // thats what we do below
        long sum1=0;
        long sum2=0;
        for(int el:source){
            sum1+=el;
        }
        for(int el:target){
            sum2+=el;
        }
        return sum1==sum2;
        
    }
}