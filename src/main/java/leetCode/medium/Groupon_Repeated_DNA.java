package leetCode.medium;
import java.util.*;
public class Groupon_Repeated_DNA {

    public static List<String> findRepeatedDnaSequences(String s) {
	List<String> res = new LinkedList<String>();
	if (s.length() < 10)
	    return res;
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	for (int i = 0; i < s.length() - 9; i++) {
	    String sub = s.substring(i, i + 10);

	    if (map.containsKey(sub)) {
		map.put(sub, map.get(sub) + 1);
	    } else {
		map.put(sub, 1);
	    }
	}
	for (String sub : map.keySet()) {
	    // System.out.println(sub +" "+map.get(sub));
	    if (map.get(sub) > 1)
		res.add(sub);
	}
	// Collections.sort(res);
	return res;
    }

}
