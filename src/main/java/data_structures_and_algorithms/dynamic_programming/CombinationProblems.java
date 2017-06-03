package data_structures_and_algorithms.dynamic_programming;

import java.util.*;

public class CombinationProblems {

	public CombinationProblems() {

	}

	public static List<List<Integer>> combine(int n, int k) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = i + 1;
		List<List<Integer>> mainList = new LinkedList<List<Integer>>();
		Set<List<Integer>> res = new LinkedHashSet<List<Integer>>();
		if (k == 0)
			return mainList;
		for (int i = 0; i < a.length; i++) {
			res.addAll(combi(a, i, a.length - 1, k));
		}
		for (List<Integer> i : res)
			mainList.add(i);
		return mainList;
	}

	public static List<List<Integer>> combineSum(int n, int k) {
		int[] a = { 2, 2, 3, 7 };

		List<List<Integer>> mainList = new LinkedList<List<Integer>>();
		Set<List<Integer>> res = new LinkedHashSet<List<Integer>>();
		if (k == 0)
			return mainList;
		for (int i = 0; i < a.length; i++) {
			res.addAll(combi(a, i, a.length - 1, k));
		}
		for (List<Integer> i : res) {
			if (ListSum(i) == n)
				mainList.add(i);
		}
		return mainList;
	}

	public static int ListSum(List<Integer> l) {
		int sum = 0;
		for (Integer i : l) {
			sum += i;
		}
		return sum;
	}

	static Set<List<Integer>> combi(int[] a, int start, int end, int k) {
		Set<List<Integer>> mainList = new LinkedHashSet<List<Integer>>();
		if (k > end - start + 1 || end < start)
			return mainList;
		if (end == start) {
			LinkedList<Integer> subList = new LinkedList<Integer>();
			subList.add(a[start]);
			mainList.add(subList);
		}
		if (k == 1) {
			for (int i = start; i <= end; i++) {
				LinkedList<Integer> subList = new LinkedList<Integer>();
				subList.add(a[i]);
				mainList.add(subList);
			}
		} else {
			if (k == end - start + 1) {
				LinkedList<Integer> subList = new LinkedList<Integer>();
				for (int i = start; i <= end; i++) {
					subList.add(a[i]);
				}
				mainList.add(subList);
			} else {
				for (int i = start; i <= end; i++) {
					Set<List<Integer>> temp = combi(a, i + 1, end, k - 1);
					if (!temp.isEmpty())
						mainList.addAll(temp);
				}
				for (List<Integer> l : mainList) {
					((LinkedList<Integer>) l).addFirst(a[start]);
				}
			}
		}
		return mainList;
	}

	public static int Ways(int sum, int one, int two, int five, int ten,
			int last) {
		if (last == 1 && sum <= one)
			return 1;
		if (last == 4) {
			int ways = 0;
			ways += Ways(sum, one, two, five, 0, 3);
			while (sum - 10 >= 0 && ten > 0) {
				ways += Ways(sum - 10, one, two, five, 0, 3);
				ten = ten - 1;
				sum = sum - 10;
			}
			return ways;
		}

		if (last == 3) {
			int ways = 0;
			ways += Ways(sum, one, two, 0, 0, 2);

			while (sum - 5 >= 0 && five > 0) {
				ways += Ways(sum - 5, one, two, 0, 0, 2);
				sum = sum - 5;
				five = five - 1;
			}

			return ways;
		}

		if (last == 2) {
			int ways = 0;
			ways += Ways(sum, one, 0, 0, 0, 1);

			while (sum - 2 >= 0 && two > 0) {
				ways += Ways(sum - 2, one, 0, 0, 0, 1);
				sum = sum - 2;
				two = two - 1;
			}

			return ways;
		}

		return 0;
	}

	public static int coinage(int sum, int[][] map, int index) {
		if (sum < 0)
			return 0;
		if (sum == 0)
			return 1;
		else {
			int s = 0;
			for (int i = index; i >= 0; i--) {
				if (sum >= map[i][0]) {
					int diff = sub(sum, map[i][0], map[i][1]);
//					System.out.println(diff);
					if (diff >= 0) {
						// map[i][1] = 0;
						s += coinage(diff, map, i - 1);
						// map[i][1] += 1;
					}
				}
			}
			return s;
		}
	}

	public static int sub(int sum, int key, int value) {
		while (sum >= 0 && value > 0) {
			sum -= key;
			value--;
		}
		if (sum < 0)
			return sum + key;
		else
			return sum;
	}

	public static void main(String[] args) {
		int[][] a = new int[4][2];
		a[0][0] = 1;
		a[0][1] = 28;

		a[1][0] = 2;
		a[1][1] = 33;

		a[2][0] = 5;
		a[2][1] = 10;

		a[3][0] = 10;
		a[3][1] = 8;

		System.out.println(coinage(26, a, 3));
	}

}
