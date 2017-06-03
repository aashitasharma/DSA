package leetCode.medium;
import java.util.*;
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> mainlist=new LinkedList<List<Integer>>();
        mainlist.add(new LinkedList<Integer>());
        if(nums.length==0)
            return mainlist;
        else{
            for(int i=0;i<nums.length;i++){
                LinkedList<List<Integer>> temp=copyList(mainlist);
                for(List<Integer> l:mainlist){
                    l.add(nums[i]);
                }
                mainlist.addAll(temp);
            }
            for(List<Integer> l:mainlist){
                    Collections.sort(l);
            }
            return mainlist;
        }
    }
    public LinkedList<List<Integer>> copyList(LinkedList<List<Integer>> list){
        LinkedList<List<Integer>> newlist=new LinkedList<List<Integer>>();
        for(List<Integer> l:list){
            List<Integer> newl=new LinkedList<Integer>();
            for(Integer i:l)
                newl.add(i);
            newlist.add(newl);
        }
        return newlist;
    }

}
