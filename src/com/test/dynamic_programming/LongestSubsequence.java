package com.test.dynamic_programming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubsequence {

    public LongestSubsequence() {
	// TODO Auto-generated constructor stub

    }

    /**
     * longest common substring
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static int longestSub(String s1, String s2) {
	int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
	int res = 0;
	for (int i = 1; i < lcs.length; i++) {
	    for (int j = 1; j < lcs[0].length; j++) {
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
		    lcs[i][j] = lcs[i - 1][j - 1] + 1;
		    res = Math.max(res, lcs[i][j]);
		}
	    }
	}
	return res;
    }

    /**
     * Longest increasing subsequence naive O(n^2) Follow Up 1. Design an
     * algorithm to construct the longest increasing list. Also, model your
     * solution using DAGs.
     * 
     * 2. Design an algorithm to construct all increasing lists of equal longest
     * size.
     * 
     * 3. Is the above algorithm an online algorithm?
     * 
     * 4. Design an algorithm to construct the longest decreasing list..
     * 
     * @param args
     */
    public static int LIS(int[] a) {
	int[] lis = new int[a.length];
	Set<Integer> list = new HashSet<Integer>();
	Arrays.fill(lis, 1);
	for (int i = 1; i < a.length; i++) {
	    for (int j = 0; j < i; j++) {
		if (a[i] > a[j] && lis[i] < lis[j] + 1) {
		    lis[i] = lis[j] + 1;
		}
	    }
	}
	int max = 0;
	int prev = 0;
	for (int i = 0; i < lis.length; i++) {
	    if (prev < lis[i]) {
		list.add(a[i]);
		prev = lis[i];
	    }
	    max = Math.max(max, lis[i]);
	}
	System.out.println(list);
	return max;
    }

    /**
     * get all substrings of a given string O(n^2);
     * 
     * @param s
     * @return
     */
    public static List<String> allSubstrings(String s) {
	List<String> mainlist = new LinkedList<String>();
	List<StringBuilder> prevlist = new LinkedList<StringBuilder>();
	for (int i = 0; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    if (mainlist.isEmpty()) {
		mainlist.add(ch + "");
		prevlist.add(new StringBuilder(ch + ""));
	    } else {
		for (StringBuilder sb : prevlist) {
		    sb.append(ch);
		    mainlist.add(sb.toString());
		}
		prevlist.add(new StringBuilder(ch + ""));
		mainlist.add(ch + "");
	    }
	}
	return mainlist;
    }

    /**
     * Longest COmmon Subsequence, only length O(n^2)
     * 
     * @param s1
     * @param s2
     * @return
     */
    public static int lcs(String s1, String s2) {
	int res = 0;
	int[][] lcs = new int[s1.length() + 1][s2.length() + 1];
	for (int i = 0; i < s1.length(); i++) {
	    char ch1 = s1.charAt(i);
	    for (int j = 0; j < s2.length(); j++) {
		char ch2 = s2.charAt(j);
		if (ch1 == ch2) {
		    lcs[i + 1][j + 1] = 1 + lcs[i][j];
		} else
		    lcs[i + 1][j + 1] = Math.max(lcs[i][j + 1], lcs[i + 1][j]);
	    }
	}
	return lcs[s1.length()][s2.length()];
    }

    /**
     * Longest Common Subsequence with output of actual sequence
     * 
     * @param a1
     * @param a2
     * @return
     */
    public static void lcs(int[] a1, int[] a2) {
	int[][] lcs = new int[a1.length + 1][a2.length + 2];
	for (int i = 0; i < a1.length; i++) {
	    for (int j = 0; j < a2.length; j++) {
		if (a1[i] == a2[j])
		    lcs[i + 1][j + 1] = 1 + lcs[i][j];
		else
		    lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
	    }
	}
	System.out.println(lcs[a1.length][a2.length]);
	int[] l = new int[lcs[a1.length][a2.length]];
	int k = 0;
	int i = lcs.length - 1;
	int j = lcs[0].length - 1;
	while (true) {
	    if (lcs[i - 1][j] == lcs[i][j - 1] && a1[i - 1] == a2[j - 1]) {
		l[k++] = lcs[i][j];
		if (l.length == lcs[a1.length][a2.length])
		    break;
		i--;
		j--;
	    } else {
		if (lcs[i - 1][j] == lcs[i][j - 1]) {
		    i--;
		} else if (lcs[i - 1][j] > lcs[i][j - 1])
		    i--;
		else
		    j--;
	    }
	}

	System.out.println(l);

    }

    /**
     * House Robber Problem
     * Recursive equation: money[i]=max(a[i]+money[i-2], money[i-1]);
     * 
     * @param args
     */
    public static int houseRobber(int[] a) {
	if (a.length == 0)
	    return 0;
	int[] money = new int[a.length];
	money[0] = a[0];
	money[1] = Math.max(a[0], a[1]);
	for (int i = 2; i < a.length; i++) {
	    money[i] = Math.max(a[i] + money[i - 2], money[i - 1]);
	}
	int sum = 0;
	for (int i : money)
	    sum += i;
	return sum;
    }

    public static void main(String[] args) {
	int[] a = { 10, 22, 9, 33, 21, 11, 41, 60, 111 };
	// System.out.println(LIS(a));
	int[] b = { 1, 2, 3, 4, 1 };
	int[] c = { 3, 4, 1, 2, 1, 3 };
	lcs(b, c);
	// System.out.println();
	// System.out.println(longestSub("SHINCHAN", "NOHARAAA"));
    }

}
