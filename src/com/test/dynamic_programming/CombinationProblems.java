package com.test.dynamic_programming;

import java.util.*;

public class CombinationProblems {

    public CombinationProblems() {

    }

    public static void main(String[] args) {
	System.out.println(combineSum(2, 1));
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
	int[] a = {2,2,3,7};

	List<List<Integer>> mainList = new LinkedList<List<Integer>>();
	Set<List<Integer>> res = new LinkedHashSet<List<Integer>>();
	if (k == 0)
	    return mainList;
	for (int i = 0; i < a.length; i++) {
	    res.addAll(combi(a, i, a.length - 1, k));
	}
	for (List<Integer> i : res){
	    if(ListSum(i)==n)
		mainList.add(i);
	}
	return mainList;
    }

    public static int ListSum(List<Integer> l){
	int sum=0;
	for(Integer i:l){
	    sum+=i;
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

}
