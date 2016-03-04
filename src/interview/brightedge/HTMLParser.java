package interview.brightedge;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Parses Contents of URL from various HTML tags
 * 
 * @author Ankit
 *
 */
public class HTMLParser {
    private ArrayList<String> rawTokens;
    private Document doc;

    /**
     * 
     * @param url
     * @throws IOException
     */
    public HTMLParser(String url) throws IOException, IllegalArgumentException, MalformedURLException {
	rawTokens = new ArrayList<String>();
	doc = Jsoup.connect(url).get();
    }

    /** 
     * Overloaded method to parse title
     * 
     * @param rawTokens
     */
    private void parseTitle(ArrayList<String> rawTokens) {
	Elements imports = doc.select("title");
	for (Element link : imports) {
	    rawTokens.add(TokenProcessor.processString(link.text()));
	}
    }

    /**
     * Overloaded method to parse headings
     * 
     * @param rawTokens
     */
    @SuppressWarnings("unused")
    private void parseHeading(ArrayList<String> rawTokens) {
	Elements headins = doc.select("h1");
	for (Element link : headins) {
	    rawTokens.add(TokenProcessor.processString(link.text()));
	}
    }

    /**
     * Parse all the headings
     * 
     * @param rawTokens
     */
    private void parseHeading() {
	Elements headins = doc.select("h1");
	for (Element link : headins) {
	    rawTokens.add(TokenProcessor.processString(link.text()));
	}
    }

    /**
     * Parse the title
     * 
     * @param rawTokens
     */
    private void parseTitle() {
	Elements imports = doc.select("title");
	for (Element link : imports) {
	    rawTokens.add(TokenProcessor.processString(link.text()));
	}
    }

    /**
     * Parse body text
     */
    private void parseBody() {
	Elements e = doc.select("p,h2,h3,h4,h5,h6");
	rawTokens.add(TokenProcessor.processString(e.text()));
    }

    /**
     * Parse image tags
     */
    private void parseMedia() {
	Elements media = doc.select("[src]");
	for (Element src : media) {
	    if (src.tagName().equals("img"))
		rawTokens.add(TokenProcessor.processString(src.attr("alt")));
	}

    }

    /**
     * Parse Meta Tags
     */
    private void parseMetaTag() {
	Elements media = doc.select("meta");
	for (Element src : media)
	    rawTokens.add(TokenProcessor.processString(src.attr("content")));
    }

    /**
     * Overloaded Method for parsing Meta Tags
     * 
     * @param rawTokens
     */
    private void parseMetaTag(ArrayList<String> rawTokens) {
	Elements media = doc.select("meta");
	for (Element src : media)
	    rawTokens.add(TokenProcessor.processString(src.attr("content")));
    }

    /**
     * @return the rawTokens
     */
    public ArrayList<String> getRawTokens() {
	return rawTokens;
    }

    /**
     * 
     * @return the list of tokens after parsing
     */
    public ArrayList<String> parse() {
	parseBody();
	parseMedia();
	parseHeading();
	parseMetaTag();
	parseTitle();
	return getRawTokens();
    }

    /**
     * 
     * @return The list of headings and meta tags for computing relevance
     */
    public ArrayList<String> parseHeadings() {
	ArrayList<String> headings = new ArrayList<String>();
	parseHeading(headings);
	parseTitle(headings);
	parseMetaTag(headings);
	return headings;
    }
}
