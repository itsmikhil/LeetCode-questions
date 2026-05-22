class Solution {

    long MOD = 1000000007;

    long pow(long x, long b) {

        if (b == 0) {
            return 1;
        }

        long halfPow = pow(x, b / 2);

        long halfPowSq = (halfPow * halfPow) % MOD;

        if (b % 2 != 0) {
            halfPowSq = (x * halfPowSq) % MOD;
        }

        return halfPowSq;
    }

    public int countGoodNumbers(long n) {

        // even nos=> 0,2,4,6,8=>5
        // prime nos=>2,3,5,7=>4

        // note leading zeros are allowed
        // note how overflow is handled with modulo value(given) in above function ans also while submitting the ans
        long even = (n + 1) / 2; // position of even index
        long odd = n / 2; //position of odd index

        return (int)((pow(5, even) * pow(4, odd)) % MOD);
    }
}