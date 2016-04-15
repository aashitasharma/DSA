package medium;

public class NextPermutation {

	public NextPermutation() {

	}

	public static void nextPermutation(int[] a) {
		if (a == null || a.length == 0)
			return;
		int k = 0;
		for (int i = a.length-1; i > 0; i--) {
			if (a[i] > a[i - 1]) {
				k = i-1;
				break;
			}
		}
		if (k == 0){
			reverse(a, 0, a.length-1);
			return;
		}
		int highest_index = 0;
		for (int i = a.length-1; i > k; i--) {
			if (a[i] > a[k]) {
				highest_index = i;
				break;
			}
		}
		a[k] = a[highest_index] ^ a[k];
		a[highest_index] = a[highest_index] ^ a[k];
		a[k] = a[highest_index] ^ a[k];
		reverse(a, k + 1, a.length-1);
	}

	public static void reverse(int[] a, int start, int end) {
		int l = start;
		int h = end;
		while (l < h) {
			a[l] = a[l] ^ a[h];
			a[h] = a[l] ^ a[h];
			a[l] = a[l] ^ a[h];
			l++;
			h--;
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1 };
		nextPermutation(a);
		for (int i : a)
			System.out.print(i + " ");
	}
}
