package interview.brightedge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.directory.InvalidAttributesException;

/**
 * Developing the N-Grams Model
 * 
 * @author Ankit
 *
 */
public class LanguageModel {

    /**
     * 3 Grams
     */
    public static final Integer N = 3;
    /**
     * Map of tokens and its frequency
     */
    private Map<String, Integer> ngrams;

    public LanguageModel() {
	ngrams = new TreeMap<String, Integer>();
    }

    /**
     * this method generates 1grams, 2grams, 3grams and their respective
     * frequency
     * 
     * @param processedTokens
     */
    public void generateNGRAMS(ArrayList<String> processedTokens) {
	for (int j = 0; j < processedTokens.size(); j++) {
	    String temp = "";
	    for (int i = j; i < j + Math.min(N, processedTokens.size() - j); i++) {
		temp += processedTokens.get(i) + " ";
		updateMap(temp.trim());
	    }
	}
    }

    /**
     * updates the map data structure by incrementing frequency
     * 
     * @param str
     */
    private void updateMap(String str) {
	if (ngrams.containsKey(str))
	    ngrams.put(str, ngrams.get(str) + 1);
	else {
	    ngrams.put(str, 1);
	}

    }

    /**
     * @return the ngrams
     */
    public Map<String, Integer> getNgrams() {
	return ngrams;
    }

    /**
     * 
     * @param s1
     *            String one
     * @param s2
     *            String two
     * @return the Levenshtein Distance between two String to find how similar
     *         they are. Less the distance, more similar they are. Used Dynamic
     *         Programming for this instead for recursion.
     */
    private static int getLevenshteinDistance(String s1, String s2) {
	int[][] distance = new int[s1.length() + 1][s2.length() + 1];

	for (int i = 0; i <= s1.length(); i++)
	    distance[i][0] = i;
	for (int j = 1; j <= s2.length(); j++)
	    distance[0][j] = j;

	for (int i = 1; i <= s1.length(); i++)
	    for (int j = 1; j <= s2.length(); j++)
		distance[i][j] = Math.min(
			distance[i - 1][j - 1]
				+ ((s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0
					: 1), Math.min(distance[i][j - 1] + 1,
				distance[i - 1][j] + 1));

	return distance[s1.length()][s2.length()];
    }

    /**
     * 
     * @param words
     * @return The similarity map of Tokens and their Weights. Similarity is
     *         based on frequency and their Levenshtein Distance from the Meta
     *         Tags. Only Tokens that have frequency greater than one are
     *         considered.
     * 
     * 
     */
    public Map<String, Weights> getSimilarityMatrix(ArrayList<String> words) {
	Map<String, Weights> similar = new HashMap<String, Weights>();
	for (String s : words) {
	    for (String st : ngrams.keySet()) {
		if (ngrams.get(st) > 1.0) {
		    int d = getLevenshteinDistance(st.toLowerCase(),
			    s.toLowerCase());
		    if (similar.containsKey(st)) {
			Weights w1 = new Weights(ngrams.get(st), d);
			if (similar.get(st).compareTo(w1) == 1)
			    similar.put(st, similar.get(st));
			else
			    similar.put(st, w1);
		    } else
			similar.put(st, new Weights(ngrams.get(st), d));
		}
	    }
	}
	similar = MapUtil.sortByValue(similar);
	return similar;
    }

    /**
     * Print the top tokens from similarity
     * 
     * @param similarity
     * @param top
     *            number of top tokens required.
     * @param grams
     *            represents 1,2,3 grams, whichever is required.
     * @throws InvalidAttributesException
     */
    public void printTopGrams(Map<String, Weights> similarity, int top,
	    int grams) throws InvalidAttributesException {
	System.out.println(grams + " grams");
	System.out.println("----------------");
	if (grams < 1 || grams > N)
	    throw new InvalidAttributesException();
	int i = 0;
	for (String s : similarity.keySet()) {
	    String[] str = s.split(" +");

	    if (str.length == grams && !s.equals("")) {
		if (i > top)
		    break;
		System.out.println(s);
		i++;
	    }
	}
	System.out.println("----------------");
    }

}