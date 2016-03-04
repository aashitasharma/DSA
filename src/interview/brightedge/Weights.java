package interview.brightedge;
/**
 * Decides the weight of terms through a combination of frequency of occurance
 * and Levenshtein distances from headings
 * 
 * @author Ankit
 *
 */
public class Weights implements Comparable<Weights> {

    Integer freq;
    Integer distances;

    public Weights(int f, int d) {
	freq = f;
	distances = d;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((distances == null) ? 0 : distances.hashCode());
	result = prime * result + ((freq == null) ? 0 : freq.hashCode());
	return result;
    }

    /**
     * Determines if two weights are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj instanceof Weights) {
	    Weights w = (Weights) obj;
	    if (w.distances == this.distances && w.freq == this.freq)
		return true;
	}
	return false;
    }

    /**
     * @param o
     *            weight for comparing with this
     * @return 1 if frequency and distance are equal. If frequency are equal
     *         then compare distance. If frequency are not equal, then compare
     *         frequency,
     */
    @Override
    public int compareTo(Weights o) {
	// TODO Auto-generated method stub
	if (this.freq != o.freq)
	    return o.freq.compareTo(this.freq);
	else {
	    return this.distances.compareTo(o.distances);
	}
    }
}
