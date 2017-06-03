package leetCode.easy;
import java.util.*;
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
	StringBuilder sb = new StringBuilder();
	Map<Integer, Character> map = new HashMap<Integer, Character>();

	for (int i = 1; i <= 26; i++)
	    map.put(i, (char) (i + 64));
	System.out.println(map);
	while (n >= 1) {
	    int r = n % 26;
	    n = n / 26;
	    if (r == 0) {
		sb.append(map.get(26));
		n--;
	    } else {
		sb.append(map.get(r));
	    }
	}
	return sb.reverse().toString();
    }

}
