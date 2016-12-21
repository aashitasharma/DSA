package data_structures_and_algorithms.leetCode.medium;
import java.util.*;
public class WordLadder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s=new HashSet<String>();
		s.add("hot");
		s.add("dot");
		s.add("dog");
		s.add("lot");
		s.add("log");
		System.out.println(ladderLength("hit", "cog", s));
		

	}
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q=new LinkedList<String>();
        Map<String, Boolean> map=new HashMap<String, Boolean>();
        for(String s:wordList)
        	map.put(s, false);
        q.add(beginWord);
        int count=0;
        while(!q.isEmpty()){
        	String curr=q.poll();
//        	if(wordList.contains(curr))
//        		wordList.remove(curr);
        	map.put(curr, true);
        	count+=1;
        	if(isonedist(curr, endWord))
        		return count;
        	for(String s:onedist(curr, wordList)){
        		if(!map.get(s))
        			q.add(s);
        	}
        }
        return 0;
        
    }
	
	public static List<String> onedist(String ss, Set<String> l){
		List<String> a=new LinkedList<String>();
		for(String s:l){
			if(isonedist(s, ss)){
				a.add(s);
			}
		}
//		System.out.println(a);
		return a;
	}
	
	public static boolean isonedist(String s1, String s2){
		int count=0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i))
				count+=1;
			if(count>1)
				return false;
		}
		return true;
	}

}
