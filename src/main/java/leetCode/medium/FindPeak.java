package leetCode.medium;

public class FindPeak {
	public static int findPeakElement(int[] a) {
		if(a.length==1)
			return 0;
		if(a.length==2){
			if(a[a.length-1]>a[0])
				return a.length-1;
			return 0;
		}
		int s=find(a, 0,a.length-1);
		if(s==-1){
			if(a[0]>a[1])
				return 0;
			if(a[a.length-1]>a[a.length-2])
				return a.length-1;
		}
		return s;
		
    }
	
	public static int find(int[] a, int s, int e){
		if(s>=e){
			return -1;
		}
		else{
			int mid=s+(e-s)/2;
			if(mid>0 && mid<a.length-1 && a[mid]>a[mid-1] && a[mid]>a[mid+1])
				return mid;
			int r=find(a, s, mid);
			return (r==-1)?find(a,mid+1,e):r;
		}
		
	}
	
	public static void main(String[] args){
		int[] a={1,4,3,4};
		System.out.println(findPeakElement(a));
	}
}
