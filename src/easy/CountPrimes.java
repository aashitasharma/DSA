package easy;

import java.util.*;

public class CountPrimes {
	public static int countPrimes(int n) {

		boolean[] prime=new boolean[n+1];
		Arrays.fill(prime, true);
//	    memset(prime, true, sizeof(prime));
	 
	    for (int p=2; p*p<n; p++)
	    {
	        // If prime[p] is not changed, then it is a prime
	        if (prime[p] == true)
	        {
	            // Update all multiples of p
	            for (int i=p*2; i<n; i += p)
	                prime[i] = false;
	        }
	    }
	    int count=0;
	    // Print all prime numbers
	    for (int p=2; p<n; p++)
	       if (prime[p])
	          count++;
	    return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(1));
	}
}
