package medium;

public class NextPermutation {

    public NextPermutation() {
	// TODO Auto-generated constructor stub
    }
    
    public static void nextPermutation(int[] a) {
	if(a==null || a.length==0)
	    return ;
	int p1=a.length-1;
	int p2=p1-1;
	while(p2>=0){
	    if(a[p1]>a[p2]){
		rotate(a, p2,p1);
		return ;
	    }
	    p2--;
	}
	reverse(a);
    } 
    
    public static void rotate(int[] a, int s, int e){
	int t=a[e];
	for(int i=e;i>=s;i--){
	    a[i]=a[i-1];
	}
	a[s]=t;
    }
    
    public static void reverse(int[] a){
	int l=0;
	int h=a.length-1;
	while(l<h){
	    a[l]=a[l]^a[h];
	    a[h]=a[l]^a[h];
	    a[l]=a[l]^a[h];
	    l++;
	    h--;
	}
    }
    public static void main(String[] args){
	int[] a={1,1,5};
	nextPermutation(a);
	for(int i:a)
	    System.out.print(i+" ");
    }
}
