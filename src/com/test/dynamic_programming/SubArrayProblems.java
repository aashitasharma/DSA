package com.test.dynamic_programming;

import java.util.*;

public class SubArrayProblems {

    public SubArrayProblems() {

    }

    public static void main(String[] args) {
	int[] a = { 1, 2, 3, 10, 4, 5, 6 };
	System.out.println(conti_subarray(a));
    }

    /**
     * Maximum of all subarrays of size k (A O(n) method) Sliding window Problem
     */
    public static List<Integer> maxSubArray_K(int[] nums, int k) {

	List<Integer> res = new LinkedList<Integer>();
	LinkedList<Integer> dq = new LinkedList<Integer>();
	dq.add(nums[0]);
	int idx = 0;
	for (int i = 1; i < nums.length; i++) {
	    if (i - idx >= k) {
		dq.removeFirst();
		idx++;
	    }
	    if (nums[i] > dq.peek()) {
		dq.addFirst(nums[i]);
		idx = i;
	    } else {
		dq.add(1, nums[i]);
		if (dq.size() > k)
		    dq.removeLast();
	    }
	    if (dq.size() > k)
		dq.removeLast();
	    if (dq.size() == k)
		res.add(dq.peek());
	}
	return res;
    }

    /**
     * contigous sum of only positive elements
     */
    public static int[] max_sub(int[] a) {
	int current_sum = 0;
	int best_sum = 0;
	int best_start_index = 0;
	int best_end_index = -1;
	int current_index = 0;
	for (int i = 0; i < a.length; i++) {
	    int val = current_sum + a[i];
	    if (val > 0) {
		if (current_sum == 0)
		    current_index = i;
		current_sum = val;
	    } else
		current_sum = 0;
	    if (current_sum > best_sum) {
		best_sum = current_sum;
		best_start_index = current_index;
		best_end_index = i;
	    }
	}
	int[] result = new int[best_end_index - best_start_index + 1];
	int k = 0;
	for (int i = best_start_index; i <= best_end_index; i++)
	    result[k++] = a[i];
	return result;

    }

    /**
     * find the subarray that has the minimum length and sum = s
     * 
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
	int sum = 0;
	for (int i : nums) {
	    if (i == s)
		return 1;
	    sum += i;
	}
	if (sum < s)
	    return 0;
	int e = nums.length - 1;
	int st = e - 1;
	int cs = nums[e];
	int bl = Integer.MAX_VALUE;
	while (st >= 0) {
	    cs += nums[st];
	    System.out.println(cs);
	    if (cs >= st) {
		if (bl > e - st + 1) {
		    bl = e - st + 1;
		    e = st;
		    cs = nums[e];
		}
	    }
	    st--;
	}
	return bl;
    }

    /**
     * given an array find the sub array that has the max sum%m in O(nlog(n))
     * 
     * @param a
     * @return
     */
    public static long subarraySum(long[] a, long m) {
	class F implements Comparable<F> {
	    Long value;
	    Integer pos;

	    public F(long v, int p) {
		value = v;
		pos = p;
	    }

	    @Override
	    public int compareTo(F o) {
		if (this.value != o.value)
		    return this.value.compareTo(o.value);
		else
		    return this.pos.compareTo(o.pos);
	    }

	    @Override
	    public boolean equals(Object o) {
		if (o instanceof F) {
		    F f = (F) o;
		    if (f.value == this.value && f.pos == this.pos)
			return true;
		}
		return false;
	    }
	}
	List<F> set = new ArrayList<F>();
	long[] prefix = new long[a.length];
	prefix[0] = a[0] % m;
	long maxF = prefix[0];
	set.add(new F(prefix[0], 0));
	for (int i = 1; i < a.length; i++) {
	    prefix[i] = (prefix[i - 1] + a[i] % m) % m;
	    maxF = Math.max(prefix[i], maxF);
	    set.add(new F(prefix[i], i));
	}

	Collections.sort(set);
	long min = Long.MAX_VALUE;
	for (int i = 0; i < set.size() - 1; i++) {
	    if (set.get(i).pos > set.get(i + 1).pos) {
		min = Math.min(min, set.get(i + 1).value - set.get(i).value);
	    }
	}
	return Math.max(m - min, maxF);

    }

    /**
     * Count number of strinctly increasing subarrays in O(n)
     */
    public static int count(int[] a) {
	int c = 0;
	int l = 1;
	for (int i = 0; i < a.length - 1; i++) {
	    if (a[i] < a[i + 1]) {
		l++;
	    } else {
		c += l * (l - 1) / 2;
		l = 1;
	    }
	}
	c += l * (l - 1) / 2;
	return c;
    }

    /**
     * Length of the largest subarray with increasing elements
     */
    public static int largestSubArray(int[] a) {
	int bl = 0;
	int l = 1;
	int p1 = 0;
	int p2 = 1;
	while (p1 < a.length && p2 < a.length) {
	    if (a[p1] < a[p2]) {
		p2++;
		l++;
		p1++;
	    } else {
		// System.out.println(l);
		bl = Math.max(bl, l);
		l = 1;
		p1 = p2;
		p2 = p1 + 1;
	    }
	}
	bl = Math.max(bl, l);
	return bl;
    }

    /**
     * Length of the largest subarray with contiguous elements Assuming array
     * does not contain duplicates O(nlogn)
     * 
     */
    public static int conti_subarray(int[] arr) {
	int n = arr.length;
	int max_len = 1; // Initialize result
	for (int i = 0; i < n - 1; i++) {
	    // Initialize min and max for all subarrays starting with i
	    int mn = arr[i], mx = arr[i];

	    // Consider all subarrays starting with i and ending with j
	    for (int j = i + 1; j < n; j++) {
		// Update min and max in this subarray if needed
		mn = Math.min(mn, arr[j]);
		mx = Math.max(mx, arr[j]);

		// If current subarray has all contiguous elements
		if ((mx - mn) == j - i)
		    max_len = Math.max(max_len, mx - mn + 1);
	    }
	}
	return max_len; // Return result

    }

}
