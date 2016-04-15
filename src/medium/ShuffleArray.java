package medium;
import java.util.*;
public class ShuffleArray {
	
	public static void shuffle(int[] arr, int end){
		if(end<=0)
			return;
		else{
			shuffle(arr, end-1);
			Random randomGenerator = new Random();
			int ran_idx=randomGenerator.nextInt(end);
			int t=arr[end];
			arr[end]=arr[ran_idx];
			arr[ran_idx]=t;
			
		}
	}
	
	public static void main(String[] args) {
		for(int j=0;j<20;j++){
			Random randomGenerator = new Random();
			int ran_idx=randomGenerator.nextInt(24);
			int[] a=new int[ran_idx];
			for(int i=0;i<ran_idx;i++)
				a[i]=i;
			shuffle(a, a.length-1);
			List<Integer> l=new ArrayList<>();
			for(int i:a){
				l.add(i);
			}
			
			System.out.println(l.toString());
		}
		
	}
	
}
