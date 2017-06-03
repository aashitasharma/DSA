package leetCode.medium;

import java.util.*;

public class CombinationSum2 {

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		Set<List<Integer>> mainlist = new HashSet<List<Integer>>();
		List<Integer> sublist = new LinkedList<Integer>();
		Set<Integer> indexes = new HashSet<Integer>();
		recurse(candidates, target, mainlist, sublist, 0, indexes);
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		for(List<Integer> l:mainlist)
			res.add(l);
		return res;
	}

	public static void recurse(int[] c, int t, Set<List<Integer>> mainlist,
			List<Integer> sublist, int idx, Set<Integer> indexes) {
		if (t == 0) {
			mainlist.add(new LinkedList<Integer>(sublist));
			indexes.clear();
			
			// sublist.clear();
		}
		if (c[idx] > t || t < 0) {
			// sublist.remove(sublist.size()-1);
			return;
		}
		for (int i = idx; i < c.length; i++) {
			if (!indexes.contains(i)) {
				indexes.add(i);
				sublist.add(c[i]);
				// System.out.println(sublist);
				recurse(c, t - c[i], mainlist, sublist, i, indexes);
				sublist.remove(sublist.size() - 1);
				indexes.remove(i);
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(combinationSum(a, target));
	}

}
