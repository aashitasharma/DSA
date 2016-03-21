package medium;

import java.util.*;

public class FourSum {

    public FourSum() {
	// TODO Auto-generated constructor stub
    }

    public static List<List<Integer>> fourSum(int[] a, int t) {

	List<List<Integer>> res = new LinkedList<List<Integer>>();
	if (a == null || a.length < 4)
	    return res;
	Set<List<Integer>> dup = new HashSet<List<Integer>>();
	Map<Integer, List<List<Integer>>> map = new HashMap<Integer, List<List<Integer>>>();
	for (int i = 0; i < a.length; i++) {
	    for (int j = i + 1; j < a.length; j++) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(i);
		l.add(j);
		if (map.containsKey(t - a[i] - a[j])) {
		    List<List<Integer>> ll = map.get(t - a[i] - a[j]);
		    ll.add(l);
		} else {
		    List<List<Integer>> ll = new ArrayList<List<Integer>>();
		    ll.add(l);
		    map.put(t - a[i] - a[j], ll);
		}
	    }
	}
	for (int i = 0; i < a.length; i++) {
	    for (int j = i + 1; j < a.length; j++) {
		if (map.containsKey(a[i] + a[j])) {
		    List<List<Integer>> cd = map.get(a[i] + a[j]);
		    for (List<Integer> l : cd) {
			if (l.get(0) != i && l.get(1) != i && l.get(0) != j
				&& l.get(1) != j) {
			    List<Integer> r = new LinkedList<Integer>();
			    r.add(a[i]);
			    r.add(a[j]);
			    r.add(a[l.get(0)]);
			    r.add(a[l.get(1)]);
			    Collections.sort(r);
			    dup.add(r);
			}
		    }

		}
	    }
	}
	for (List<Integer> l : dup)
	    res.add(l);
	return res;
    }

}
