package leetCode.hard;

import java.util.*;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1,3,-1,-3,5,3,6,7 };
		int[] s=slidingWindow(a, 3);
		for(int i:s){
			System.out.print(i+" ");
		}
	}

	public static int[] slidingWindow(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o2.compareTo(o1);
					}
				});
		int[] res = new int[a.length - k + 1];
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if (pq.size() < k)
				pq.add(a[i]);
			else {
				res[idx++] = pq.peek();
				pq.remove(a[i - k]);
				pq.add(a[i]);

			}
		}
		res[idx++] = pq.peek();

		return res;
	}
}
