package leetCode.myQuestions;

/**
 * 
 * @author Ankit
 * TODO: modify the solution
 * 
 *         Implement a meeting planner that can schedule meetings between two
 *         persons at a time.
 * 
 *         Time is represented by Unix format (also called Epoch) - a positive
 *         integer holding the seconds since January 1st, 1970 at midnight.
 * 
 *         Planner input:
 * 
 *         dur - Meeting duration in seconds (a positive integer). timesA,
 *         timesB - Availability of each person, represented by an array of
 *         arrays. Each sub-array is a time span holding the start (first
 *         element) and end (second element) times. You may assume that time
 *         spans are disjointed.
 * 
 *         Planner output:
 * 
 *         Array of two items - start and end times of the planned meeting,
 *         representing the earliest opportunity for the two persons to meet for
 *         a dur length meeting. If no possible meeting can be scheduled, return
 *         an empty array instead.
 * 
 *         Design and implement an efficient solution and analyze its runtime
 *         and space complexity.
 */
public class SchedulePlanner {

    public SchedulePlanner() {

    }

    public int planner(int duration, int[][] timesA, int[][] timesB) {
	int ia = 0;
	int ib = 0;
	while (ia < timesA.length && ib < timesB.length) {
	    int start = Math.max(timesA[ia][0], timesB[ib][0]);
	    int end = Math.min(timesA[ia][1], timesB[ib][1]);
	    if (start + duration <= end)
		return 0;
	    else {
		if (timesA[ia][1] < timesB[ib][1])
		    ia = ia + 1;
		else
		    ib = ib + 1;
		return 0;
	    }
	}
	return 0;

    }
}
