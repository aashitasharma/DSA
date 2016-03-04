package interview.brightedge;
import java.util.*;

/**
 * Generic Helper Class to sort a map by value.
 * 
 * @author Ankit
 *
 */
public class MapUtil {
    public static Map<String, Weights> sortByValue(
	    Map<String, Weights> map) {
	List<Map.Entry<String, Weights>> list = new LinkedList<Map.Entry<String, Weights>>(
		map.entrySet());
	Collections.sort(list, new Comparator<Map.Entry<String, Weights>>() {
	    public int compare(Map.Entry<String, Weights> o1, Map.Entry<String, Weights> o2) {
		return (o1.getValue()).compareTo(o2.getValue());
	    }
	});

	Map<String, Weights> result = new LinkedHashMap<String, Weights>();
	for (Map.Entry<String, Weights> entry : list) {
	    result.put(entry.getKey(), entry.getValue());
	}
	return result;
    }
}
