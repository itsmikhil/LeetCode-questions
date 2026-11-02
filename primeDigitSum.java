import java.util.* ;
import java.io.*; 

public class Solution {

	static int findSum(int num){
		int sum=0;
		while(num>0){
			int ld=num%10;
			num/=10;
			sum+=ld;
		}
		return sum;
	}

	static boolean isPrime(int num){
		if(num<2) return false;
		if(num==2) return true;
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}


    static int primeDigitSum(int l, int r){
		int count=0;
        for(int i=l;i<=r;i++){
			int sum=findSum(i);
			if(isPrime(sum)){
				count++;
			}
		}
		return count;
        
    }
}