class Solution {
    public static ArrayList<Integer> primeFac(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        // actually we wanted stop condition to be i<=Math.sqrt(n)
        // but because n value is changing because of division inside loop
        // thats we changed the condi to i*i<=n
        // why till sqrt(n) :- Because if a number n is composite, then it 
        // must have at least one factor less than or equal to √n.
        // Example:
        // n = 999983 (prime)
        //
        // Brute force:
        // check from 2 to 999982  -> ~10 lakh checks
        //
        // sqrt optimization:
        // sqrt(999983) ≈ 999
        // so we check only till 999 -> ~1000 checks
        //
        // huge computation saved
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                list.add(i);
                while(n!=0 && n%i==0){
                    n/=i;
                }
            }
        }
        // if after dividing all smaller factors something still remains,
        // then that remaining number itself is prime
        // because a composite number would have been divided earlier
        if(n!=1){
            list.add(n);
        }
        return list;
        
    }
}