class Solution {
    public String maxSumOfSquares(int num, int sum) {

        if(sum>9*num) return "";

        StringBuilder sb=new StringBuilder();
        
        int numOf9=sum/9;
        int leftOver=sum%9;
        
        for(int i=0;i<numOf9;i++){
            sb.append('9');
        }

        if (leftOver > 0) {
            sb.append((char) ('0' + leftOver));
        }

        while (sb.length() < num) {
            sb.append('0');
        }

        return sb.toString();
    }
}