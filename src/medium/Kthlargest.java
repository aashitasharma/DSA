package medium;

public class Kthlargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={5,4,3,6,8,1};
		System.out.println(partition(a, 0, a.length-1));
		for(int i:a){
			System.out.print(i+" ");
		}
	}
	 private static int partition(int[] a, int lo, int hi) {

	        int i = lo;
	        int j = hi + 1;
	        while(true) {
	            while(i < hi && less(a[++i], a[lo]));
	            while(j > lo && less(a[lo], a[--j]));
	            if(i >= j) {
	                break;
	            }
	            exch(a, i, j);
	        }
	        exch(a, lo, j);
	        return j;
	    }


    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

}
