package interview.brightedge;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import javax.naming.directory.InvalidAttributesException;

/**
 * Driver class
 * 
 * @author Ankit
 *
 */
public class WordDensityAnalysis {

    /**
     * Default if no argument in provided
     */
    public static final Integer TOPGRAMS = 100;
    /**
     * DEBUG MODE for testing purpose
     */
    public static final boolean DEBUG_MODE = true;

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
	String testURL = "";
	if (DEBUG_MODE == false) {
	    if (args.length == 0) {
		System.out.println("Please, enter one URL..");
		return;
	    }
	    testURL = args[0];
	} else
	    testURL = "http://www.cnn.com/2013/06/10/politics/edward-snowden-profile/";
	HTMLParser hp = null;
	try {
	    hp = new HTMLParser(testURL);
	} catch (IOException | IllegalArgumentException e) {
	    System.err.println(e.getMessage() + "\nIncorrect URL. Exiting...");
	    return;
	}
	TokenProcessor tp = new TokenProcessor();
	LanguageModel lm = new LanguageModel();
	lm.generateNGRAMS(tp.removeStopWords(hp.parse()));
	Map<String, Weights> similarity = lm.getSimilarityMatrix(hp
		.parseHeadings());
	int topgrams = 0;
	try {
	    if (args.length == 2) {
		try {
		    topgrams = Integer.parseInt(args[1]);
		} catch (NumberFormatException ne) {
		    System.err.println("Invalid Number Entered");
		}
		lm.printTopGrams(similarity, topgrams, 1);
		lm.printTopGrams(similarity, topgrams, 2);
		lm.printTopGrams(similarity, topgrams, 3);
	    } else {
		lm.printTopGrams(similarity, TOPGRAMS, 1);
		lm.printTopGrams(similarity, TOPGRAMS, 2);
		lm.printTopGrams(similarity, TOPGRAMS, 3);

	    }
	} catch (InvalidAttributesException e) {
	    System.err.println("Please enter correct attributes");
	}
    }
}
