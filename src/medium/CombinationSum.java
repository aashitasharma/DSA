package medium;
import java.util.*;
public class CombinationSum {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> mainlist=new ArrayList<List<Integer>>();
        List<Integer> sublist=new LinkedList<Integer>();
        recurse(candidates, target, mainlist, sublist, 0);
        return mainlist;
    }
    
    public static void recurse(int[] c, int t, List<List<Integer>> mainlist, List<Integer> sublist, int idx){
        if(t==0){
            mainlist.add(new LinkedList<Integer>(sublist));
//            sublist.clear();    
        }
        if(c[idx]>t || t<0){
//            sublist.remove(sublist.size()-1);
        	return ;
        }
        for(int i=idx;i<c.length;i++){
            sublist.add(c[i]);
//          System.out.println(sublist);
            recurse(c, t-c[i], mainlist, sublist, i);
            sublist.remove(sublist.size()-1);
        }
    }
	
	public static void main(String[] args){
		int[] a={10,1,2,7,6,1,5};
		int target=8;
		System.out.println(combinationSum(a, target));
	}
}
