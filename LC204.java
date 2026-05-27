class Solution {

    // This algo is marking non prime nos is called "Sieve of Eratosthenes"

    // Brute force :- it will give TLE 
    // void markAllComposite(int allNums[]){
    //     for(int i=2;i<allNums.length;i++){
    //         for(int j=2;i*j<allNums.length;j++){
    //             allNums[i*j]=1;
    //         }
    //     }
    // }

    // public int countPrimes(int n) {
    //     int allNums[]=new int[n+1];
    //     markAllComposite(allNums);
    //     int count=0;
    //     for(int i=2;i<allNums.length;i++){
    //         if(allNums[i]==0) count++;
    //     }
    //     return count;
    // }

    // Better:-
    void markAllComposite(int allNums[]){
        // outer loop can run till Math.sqrt(n)
        // but we cant find sqrt again and again so we do i*i<=n
        for(int i=2;i*i<=allNums.length;i++){
            // earlier inner loop started from 2
            // so if i=2 then j=2 and it will mark 2,4,6,8...
            // then when i=3 and j=2 then it would again mark 6 , which is already marked
            // then when i=4 and j=2 then it would gain mark 8,12
            // thats why we start from j=i so that seedha i*i wale term se mark karna start ho
            for(int j=i;i*j<allNums.length;j++){
                if(allNums[i*j]==1) continue;
                allNums[i*j]=1;
            }
        }
    }

    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int allNums[]=new int[n];
        markAllComposite(allNums);
        int count=0;
        // we check what are the un marked ones and we return that number
        for(int i=2;i<allNums.length;i++){
            if(allNums[i]==0) count++;
        }
        return count;
    }
}