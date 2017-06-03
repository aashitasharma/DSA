package leetCode.medium;

import java.util.*;

public class PerfectSquares {
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		List<Integer> primes = countSquares(n, dp);
		return numSquares(n, dp, primes);
	}

	public static List<Integer> countSquares(int n, int[] dp) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int p = 2; p * p <= n; p++) {
			int x = p * p;
			list.add(x);
			dp[x] = 1;
		}
		return list;
	}

	public static int numSquares(int n, int[] dp, List<Integer> primes) {
		if (n <= 0)
			return 0;
		if (dp[n] != 0)
			return dp[n];
		else {
			for (int i = 0; i < primes.size() && primes.get(i) <= n; i++) {
				int p = primes.get(i);
				int c = 0;
				if (n - p >= 0 && dp[n - p] != 0)
					c = dp[n - p] + dp[p];
				else {
					if (n - p > 0)
						c = dp[p] + numSquares(n - p, dp, primes);
				}
				if (dp[n] == 0 || c < dp[n])
					dp[n] = c;
			}
			return dp[n];
		}
	}

	public static void main(String[] args) {
		System.out.println(numSquares(7186));
	}
}
