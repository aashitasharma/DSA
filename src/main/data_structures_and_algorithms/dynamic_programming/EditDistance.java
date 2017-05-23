package data_structures_and_algorithms.dynamic_programming;

public class EditDistance {

    public EditDistance() {
	// TODO Auto-generated constructor stub
    }
    
    private static int minimum(int a, int b, int c) {
   	return Math.min(Math.min(a, b), c);
       }
    private static int computeLevenshteinDistance(String s1, String s2) {
	int[][] distance = new int[s1.length() + 1][s2.length() + 1];

	for (int i = 0; i <= s1.length(); i++)
	    distance[i][0] = i;
	for (int j = 1; j <= s2.length(); j++)
	    distance[0][j] = j;

	for (int i = 1; i <= s1.length(); i++)
	    for (int j = 1; j <= s2.length(); j++)
		distance[i][j] = minimum(
			distance[i - 1][j] + 1,
			distance[i][j - 1] + 1,
			distance[i - 1][j - 1]
				+ ((s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0
					: 1));

	return distance[s1.length()][s2.length()];
    }

}
