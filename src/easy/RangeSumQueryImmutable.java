package easy;

public class RangeSumQueryImmutable {

    public class NumArray {

	    int[] cache;
	    int[] n;
	    public NumArray(int[] nums) {
	        n=nums;
	        cache=new int[n.length];
	        int cum_sum=0;
	        for(int i=0;i<n.length;i++){
	            cum_sum+=n[i];
	            cache[i]=cum_sum;
	        }
	    }

	    public int sumRange(int i, int j) {
	        if(i==0)
	            return cache[j];
	        else
	            return cache[j]-cache[i-1];
	    }
	}


}
