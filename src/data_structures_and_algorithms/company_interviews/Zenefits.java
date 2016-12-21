package data_structures_and_algorithms.company_interviews;

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

    static int uneatenLeaves(int n, int[] a) {
	int[] b = new int[n + 1];
	for (int i = 0; i < a.length; i++) {
	    for (int j = 0; a[i] * j < n + 1; j++)
		b[a[i] * j] = 1;
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
	    if (b[i] != 1) {
		count++;
	    }
	}
	return count;
    }

    public static void main(String[] args) {
	int[] a = { 3, 7, 5 };
	int n = 20;
	// System.out.println(uneatenLeaves(a, n));
	System.out.println(uneatenLeaves(n, a));
    }

}
