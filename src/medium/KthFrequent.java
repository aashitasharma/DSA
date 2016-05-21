package medium;
import java.util.*;
public class KthFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={3,3,2,3,2,1,1,3,1,4};
		int k=2;
		System.out.println(topKFrequent(n, k));

	}
	
	static class X{
        Integer idx;
        Integer freq;
        X(int i, int f){
            idx=i;
            freq=f;
        }
        
        @Override
        public boolean equals(Object o){
            if(o instanceof X){
                if(((X)o).idx==idx)
                    return true;
            }
            return false;
        }
        
        @Override
        public String toString(){
        	return "("+idx+", "+freq+")";
        }
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Comparator<X> comparator=new Comparator<X>() {
			
			@Override
			public int compare(X o1, X o2) {
				// TODO Auto-generated method stub
				return o2.freq.compareTo(o1.freq);
			}
		};
        Map<Integer, Integer> map=new HashMap<Integer,Integer>();
        for(int i:nums){
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else{
                map.put(i, 1);
            }
        }
        Queue<X> q=new PriorityQueue<X>(comparator);
        for(Integer i:map.keySet()){
            q.add(new X(i, map.get(i)));
        }
        System.out.println(map);
        
        List<Integer> res=new ArrayList<Integer>();
        System.out.println(q);
        for(int i=0;i<k;i++){
            res.add((q.poll()).idx);
            
        }
        return res;
        
    }

}
