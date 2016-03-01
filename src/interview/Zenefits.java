package interview;

import java.util.*;

public class Zenefits {

    public Zenefits() {
	// TODO Auto-generated constructor stub
    }

    public static int flipBits(int[] a) {
	int best = Integer.MIN_VALUE;
	int c = 0;
	int ones = 0;
	boolean flag = false;
	for (int i : a) {
	    if (i == 0 && flag == false) {
		c++;
		flag = true;
	    } else {
		if (flag && i == 0) {
		    c++;
		} else if (i == 1 && flag == true) {
		    flag = false;
		    best = Math.max(best, c);
		    c = 0;
		    ones++;
		} else if (i == 1)
		    ones++;
	    }
	}

	return Math.max(best, c) + ones;
    }

    /**
     * O(2^k)
     * 
     * @param a
     * @param n
     * @return
     */
    public static int uneatenLeaves(int[] a, int n) {

	Set<Integer> caterpillars = new HashSet<Integer>();
	// k is very less
	for (int i = 0; i < a.length; i++) {
	    boolean flag = true;
	    for (int j = 0; j < a.length && flag; j++) {
		if (j!=i && a[i] % a[j] == 0)
		    flag = false;
	    }
	    if (flag) {
		caterpillars.add(a[i]);
	    }
	}
	System.out.println(caterpillars);
	List<List<Integer>> subsets=allSubSets(caterpillars);
	System.out.println(subsets);
	Set<Integer> lcm=new HashSet<Integer>();
	for(List<Integer> l:subsets){
	    if(l.size()>1){
		int lcm_i=1;
		for(Integer i:l)
		    lcm_i*=i;
		if(lcm_i<=n)
		    lcm.add(lcm_i);
	    }
	}
	System.out.println(lcm);
	
	int eatenLeaves = 0;
	for (Integer i : caterpillars) {
	    eatenLeaves += n / i;
	}
	System.out.println(eatenLeaves);
	for (Integer i : lcm) {
	    eatenLeaves -= n / i;
	    System.out.println(n / i);
	}
	
	return n - eatenLeaves;
    }

    /**
     * O(nk)
     * @param N
     * @param A
     * @return
     */
    public static int uneatenLeaves(int N, int[] A) {
	int uneatenLeaves = 0;
	int ASize = A.length;
	int countEaten = 0;

	HashMap<Integer, Integer> positionEatenHash = new HashMap<Integer, Integer>();
	for (int i = 0; i < ASize; i++) {
	    int catervalue = A[i];
	    for (int j = 1; j * catervalue <= N; j++) {
		if (!positionEatenHash.containsKey(A[i] * j)) {
		    positionEatenHash.put(A[i] * j, 1);
		    countEaten++;
		}
	    }
	}
	uneatenLeaves = N - countEaten;
	return uneatenLeaves;
    }

    public static List<List<Integer>> allSubSets(Set<Integer> set){
	List<List<Integer>> mainList=new ArrayList<List<Integer>>();
	boolean first=true;
	for(Integer i:set){
	    if(!first){
		List<List<Integer>> temp=shallowCopy(mainList);
		for(List<Integer> l:mainList){
		    l.add(i);
		}
		mainList.addAll(temp);
	    }
	    first=false;
	    List<Integer> subList=new ArrayList<Integer>();
	    subList.add(i);
	    mainList.add(subList);
	    
	}
	return mainList;
    }
    
    public static List<List<Integer>> shallowCopy(List<List<Integer>> ml){
	List<List<Integer>> temp=new ArrayList<List<Integer>>();
	for(List<Integer> l:ml){
	    List<Integer> subList=new ArrayList<Integer>();
	    for(Integer i:l){
		subList.add(i);
	    }
	    temp.add(subList);
	}
	return temp;
    }
    
    public static void main(String[] args) {
	int[] a = {3,7,5,2};
	int n=30;
	System.out.println(uneatenLeaves(a, n));
	System.out.println(uneatenLeaves(n, a));
    }

}
