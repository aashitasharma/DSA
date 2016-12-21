package data_structures_and_algorithms.leetCode.hard;

import java.util.*;

public class MaxPointsOnALine {

    class Point {
	int x;
	int y;

    }

    public MaxPointsOnALine() {
    }

    // TODO Auto-generated constructor stub

    /*
     * A line is determined by two factors,say y=ax+b
     * 
     * If two points(x1,y1) (x2,y2) are on the same line(Of course).
     * 
     * Consider the gap between two points.
     * 
     * We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled
     * since b is a constant
     * 
     * If a third point (x3,y3) are on the same line. So we must have y3=ax3+b
     * 
     * Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * 
     * Since a is a rational, there exists y0 and x0,
     * y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a
     * 
     * So we can use y0&x0 to track a line;
     */

    public int maxPoints(Point[] points) {
	// Write your code here
	if (points == null || points.length == 0) {
	    return 0;
	}
	if (points.length < 2)
	    return points.length;

	int res = -1;
	for (int i = 0; i < points.length; i++) {
	    int samex = 1;
	    int samep = 0;
	    HashMap<Double, Integer> count = new HashMap<Double, Integer>();
	    for (int j = i + 1; j < points.length; j++) {
		if (points[j].x == points[i].x && points[j].y == points[i].y) {
		    samep++;
		}
		if (points[j].x == points[i].x) {
		    samex++;
		    continue;
		}
		double slope = (double) (points[j].y - points[i].y)
			/ (double) (points[j].x - points[i].x);
		if (count.containsKey(slope)) {
		    count.put(slope, count.get(slope) + 1);
		} else {
		    count.put(slope, 2);
		}
		res = Math.max(res, count.get(slope) + samep);
	    }
	    res = Math.max(res, samex);
	}
	return res;
    }

}
