package medium;

import java.util.*;

public class ReconstructItinery {
	public List<String> findItinerary(String[][] tickets) {
		Comparator<String> comparator=new Comparator<String>() {
			@Override
			public int compare(String s1, String s2){
				return s1.compareTo(s2);
			}
		};
		Map<String, Queue<String>> al=new HashMap<String, Queue<String>>();
		Stack<String> stack=new Stack<String>();
		List<String> res=new ArrayList<String>();
		for(String[] j:tickets){
			if(!al.containsKey(j[0]))
				al.put(j[0], new PriorityQueue(comparator));
			al.get(j[0]).add(j[1]);
		}
		stack.add("JFK");
		while(!stack.isEmpty()){
			String s=stack.pop();
			res.add(s);
			while(!al.get(s).isEmpty())
				stack.add(al.get(s).poll());
		}
		return res;
	}
}
