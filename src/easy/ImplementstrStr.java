package easy;

/**
 * Pattern Matching without any advanced data structure.
 * @author Ankit
 *
 */
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
	int h_i = 0;
	int n_i = 0;
	int first = -1;
	boolean flag = true;
	if (haystack.length() < needle.length())
	    return first;
	if ((haystack.length() == 0 || needle.length() == 0))
	    return 0;
	while (n_i < needle.length() && h_i < haystack.length()) {
	    if (haystack.charAt(h_i) == needle.charAt(n_i)) {
		n_i++;
		if (flag)
		    first = h_i;
		flag = false;

		h_i++;
	    } else {

		if (flag == true) {
		    h_i++;
		} else {
		    h_i = first + 1;
		    n_i = 0;
		    flag = true;
		    first = -1;
		}
	    }
	}
	if (n_i == needle.length())
	    return first;
	else
	    return -1;
    }

}
