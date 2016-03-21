package medium;

public class RotateImage {

    public RotateImage() {
	// TODO Auto-generated constructor stub
    }
    public static void rotate(int[][] a) {
	int n=a.length;
	int layer=n-1;
	while(layer>0){
	    int i=layer;
	    while(i>n-1-layer){
		int t=a[n-1-layer][n-i-1];
		a[n-1-layer][n-i-1]=a[i][n-layer-1];
		a[i][n-layer-1]=a[layer][i];
		a[layer][i]=a[n-i-1][layer];
		a[n-i-1][layer]=t;
		i--;
	    }
	    layer-=1;
	}
    }

}
