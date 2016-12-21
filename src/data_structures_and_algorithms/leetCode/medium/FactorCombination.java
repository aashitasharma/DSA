package data_structures_and_algorithms.leetCode.medium;

import java.util.*;

public class FactorCombination {
	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> mainlist = new LinkedList<List<Integer>>();
		factors(n, mainlist, new LinkedList<Integer>(), 2);
		return mainlist;

	}

	public static void factors(int n, List<List<Integer>> mainlist,
			List<Integer> sublist, int start) {
		if (n <= 1) {
			if (sublist.size() > 1) {
//				System.out.println(sublist);
				mainlist.add(new LinkedList<Integer>(sublist));
//				System.out.println(mainlist);
			}
			return;
		}

		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				sublist.add(i);
				factors(n / i, mainlist, sublist, i);
				
				sublist.remove(sublist.size() - 1);
//				System.out.println(mainlist);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(getFactors(32));
	}
}
