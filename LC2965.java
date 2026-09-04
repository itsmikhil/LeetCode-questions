class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        // mathematical approach

        // Simple maths hai
        // smajh lo

        // x-> repating num
        // y->misisng num
        // [1,x,x,3]
        // actualSum= 1+x+x+3
        // sumThatShouldbeThere = 1+x+3+y
        // actualSum-sumThatShouldbeThere=x-y --> eqn1
        // actualSquaredSum= 1 +x2 +x2 +9
        // squaredSumThatShouldbeThere=1+x2+9+y2
        // actualSquaredSum - squaredSumThatShouldbeThere=x2-y2 -> eqn2
        //                                               =(x+y)(x-y)
        //                                               =(x+y)  -> divide by eqn 1 -> eqn3
        // abhi 2 eqn  variable
        // (eqn1+eqn3)/2 =>x
        // y= (eqn3)-x

        int n=grid.length;
        long squaredSumThatShouldBeThere=0;
        long sumThatShouldBeThere=0;
        long actualSum=0;
        long actualSqauredSum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                int num = n * i + j + 1;
                // Note how are avaoiding overflow 
                // (long)-> typecasting -> wont work
                squaredSumThatShouldBeThere+= 1L * num * num;;
                sumThatShouldBeThere+=num;

                // Note how are avaoiding overflow 
                // (long)-> typecasting -> wont work
                actualSqauredSum+=(1L * grid[i][j] * grid[i][j]);
                actualSum+=grid[i][j];

            }
        }

        long eqn1=actualSum-sumThatShouldBeThere;

        long eqn2=actualSqauredSum-squaredSumThatShouldBeThere;

        long eqn3=eqn2/eqn1;

        int repeatingNumber=(int)(eqn1+eqn3)/2;

        int missingNumber=(int) (eqn3-repeatingNumber);
        
        int ans[]=new int[2];
        ans[0]=repeatingNumber;
        ans[1]=missingNumber;
        return ans;
    }
}