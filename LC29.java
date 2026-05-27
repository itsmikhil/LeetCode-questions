class Solution {
    public int divide(int dividend, int divisor) {
        // eg case 21/3
        // ans should be 7 => 3*7
        // can we write it as 3*(4+2+1) => broke 7 into the powers of 2
        // dry run
        // a=21
        // can i remove 3*(2^0) yes
        // can i remove 3*(2^1) yes
        // can i remove 3*(2^2) yes
        // can i remove 3*(2^3) no
        // so i will remove 3*(2^2) then a = 21-12=>9  and quotient = 2^2 =>4
        // again can i remove 3*(2^0) yes
        // can i remove 3*(2^1) yes
        // can i remove 3*(2^2) no
        // so i will remove 3*(2^1) then a = 9-6=>3 and quotient = 4+2=>6
        // again can i remove 3*(2^0) yes
        // can i remove 3*(2^1) no
        // so i will remove 3*(2^0) then a = 3-3=>0 and quotient = 4+2+1=>7

        // Learning:- we are trying to remove bigger chunk
        if(dividend==divisor) return 1;
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean sign=false;
        if(dividend<0 && divisor>0) sign=true;
        if(dividend>0 && divisor<0) sign=true;

        long a=Math.abs((long)dividend); // abs nikalne ke pehle he woh overflow ho raha tha  ==> IMP
        long b=Math.abs((long)divisor); // abs nikalne ke pehle he woh overflow ho raha tha
        long quotient=0;
        while(a>=b){
            int pow=0;
            while(a>=(b<<(pow+1))){
                pow++;
            }
            quotient+=(1<<pow);
            a-=(b<<pow);
        }
        return (int) (sign?-quotient:quotient);
    }
}