package leetCode.easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
	int min = Integer.MAX_VALUE;
	String result = "";
	for (int i = 0; i < strs.length; i++) {
	    if (min > strs[i].length()) {
		min = strs[i].length();
		result = strs[i];
	    }
	}
	int pointer = result.length();
	for (int i = 0; i < strs.length; i++) {
	    if (!strs.equals(result)) {
		int j = 0;
		while (j < pointer && result.charAt(j) == strs[i].charAt(j))
		    j++;
		pointer = j;
	    }
	}
	return result.substring(0, pointer);
    }

}
