class Solution {

    double helper(double x,long n){
        if(n==0){
            return 1;
        }
        double halfPow=helper(x,n/2);
        double halfPowSq=halfPow * halfPow;
        if(n%2!=0){
            halfPowSq=x*halfPowSq;
        }
        return halfPowSq;
    }

    public double myPow(double x, int n) {

        // helper fucn mai we are using long because 
        // INTERVIEW QUES:- int is 32 bits but last bit is reserved for sign therefore 2^31 nums posiible
        // we know ki int ki range is -2^31 se (2^31 - 1)
        // positive side mai minus 1 aata hai kyuki zero bhi toh aata hai beech mai 
        // jo ki na posi hota hai na negi

        // yaha pe agar n is neg toh hum x^n find karte hai aur fir 1/(x^n) kar dete hai
        // but neg int ki range is -2^31
        // and posi ki range is 2^31 -1 
        // isliye when n=-2^31 is asked and we call helper(x,-n)
        //  tab overflow aayega because posi int ki range toh 2^31-1 hai
        // isliye long use kiya

        if(n==0){
            return 1;
        }else if(n<0){
            return 1/helper(x,-n);
        }else{
            return helper(x,n);
        }
    }
}