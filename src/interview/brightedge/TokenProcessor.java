package interview.brightedge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Removes the stopwords, punctions and other special characters from raw
 * tokens.
 * 
 * @author Ankit
 *
 */
public class TokenProcessor {

    public static final String STOPWORDS_FILE = "stopwords.txt";
    public static final String REGEX = "[^a-zA-Z0-9 ]";

    /**
     * Reads a file of all stop words and puts them in a list.
     * List of Stop Words taken from 
     * http://www.lextek.com/manuals/onix/stopwords1.html
     * @return the list of all stop words.
     */
    private ArrayList<String> getStopWords() {
	ArrayList<String> stopwords = new ArrayList<String>();
	try {
	    BufferedReader br = new BufferedReader(new FileReader(new File(
		    STOPWORDS_FILE)));
	    String line = "";
	    while ((line = br.readLine()) != null)
		stopwords.add(line);
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return stopwords;
    }

    /**
     * removing all the stopwords from the raw text
     * 
     * @param rawTokens
     * @return list of tokens with no stop words.
     */
    public ArrayList<String> removeStopWords(ArrayList<String> rawTokens) {
	ArrayList<String> sw = getStopWords();
	ArrayList<String> processedTokens = new ArrayList<String>();
	for (String token : rawTokens) {
	    String[] s = token.split(" +");
	    for (String st : s) {
		boolean flag = false;
		for (int i = 0; i < sw.size() && flag == false; i++) {
		    if (st.equals(sw.get(i)))
			flag = true;
		}
		if (flag == false)
		    processedTokens.add(st);
	    }

	}
	return processedTokens;
    }

    /**
     * Removes all non alphanumeric characters.
     * @param raw string to be processed
     * @return String with only lowercase alphanumeric characters
     */
    public static String processString(String raw) {
	if (!raw.startsWith("http"))
	    return raw.trim().replaceAll(REGEX, "").toLowerCase();
	else
	    return "";
    }

}
