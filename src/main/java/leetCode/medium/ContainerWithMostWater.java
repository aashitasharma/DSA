package leetCode.medium;

public class ContainerWithMostWater {

    public ContainerWithMostWater() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
    
    /**
     * O(n) approach is that we maintain two pointer one at start and other at the end.
     * We calculate the area and compare it with the maxArea value that we currently have. 
     * Then we increment or decrement depending upon whichever is smaller 
     * @param a
     * @return
     */
    public int maxArea(int[] a){
	int l=0;
	int h=a.length;
	int maxarea=0;
	while(l<h){
	   maxarea=Math.max(maxarea, (h-l)*Math.min(a[l], a[h]));
	   if(a[l]<a[h])
	       l++;
	   else
	       h--;
	}
	return maxarea;
    }

}
