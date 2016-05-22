package medium;

public class SearchforaRange {

	public SearchforaRange() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = {8};
		int[] res = searchRange(a, 8);
		System.out.println(res[0] + " " + res[1]);
	}

	public static int[] searchRange(int[] a, int i) {
		// TODO Auto-generated method stub
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		searchRange(a, 0, a.length - 1, res, i);
		return res;
	}

	public static void searchRange(int[] a, int s, int e, int[] res, int target) {
		if (s >= e){
			if(a[s]==target){
				res[0]=Math.min(res[0], s);
				res[1]=Math.max(res[1], e);
			}
			return;
		}
		else {
			int mid = s + (e - s) / 2;
			if (a[mid] == target) {
				if (mid > 0 && a[mid] > a[mid - 1]) {
					res[0] = mid;
				} else {
					if (mid > 0)
						searchRange(a, s, mid, res, target);
					else {
						if (a[mid] == a[s])
							res[0] = mid;
					}
				}
				if (mid < a.length && a[mid] < a[mid + 1]) {
					res[1] = mid;
				} else {
					if (mid < a.length)
						searchRange(a, mid + 1, e, res, target);
					else {
						if (a[mid] == a[e])
							res[1] = mid;
					}

				}
			} else {
				if (a[mid] > target) {
					searchRange(a, s, mid, res, target);
				} else {
					searchRange(a, mid + 1, e, res, target);
				}
			}
		}
	}

}
