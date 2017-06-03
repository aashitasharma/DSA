package leetCode.myQuestions;

import java.util.*;

enum Direction {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    Direction(int x) {

    }

}

public class BotPath {

    public static String generate_Input() {
	StringBuilder sb = new StringBuilder();
	Random rand = new Random();
	int length = rand.nextInt(500);
	for (int i = 0; i < length; i++) {
	    int j = rand.nextInt(4);
	    switch (j - 1) {
	    case 0: {
		sb.append('^');
		break;
	    }
	    case 1: {
		sb.append('V');
		break;
	    }
	    case 2: {
		sb.append('<');
		break;
	    }
	    case 3: {
		sb.append('>');
		break;
	    }
	    }
	}
	return sb.toString();
    }

    public BotPath() {
	// TODO Auto-generated constructor stub
    }

    public static boolean botpath(String s) {
	boolean res = false;
	class Point {
	    int x;
	    int y;

	    Point(int x, int y) {
		this.x = x;
		this.y = y;
	    }

	    @Override
	    public boolean equals(Object o) {
		if (o instanceof Point) {
		    Point p = (Point) o;
		    if (p.x == this.x && this.y == p.y)
			return true;
		}
		return false;
	    }

	    @Override
	    public String toString() {
		return "(" + x + ", " + y + ")";
	    }

	    @Override
	    public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x * y;
		return result;
	    }
	}

	Set<Point> set = new HashSet<Point>();
	Point curr = new Point(0, 0);
	set.add(new Point(0, 0));
	for (int i = 0; i < s.length(); i++) {
	    char ch = s.charAt(i);
	    switch (ch) {
	    case '^': {
		curr.y++;
		break;
	    }
	    case '>': {
		curr.x++;
		break;
	    }
	    case '<': {
		curr.x--;
		break;
	    }
	    case 'V': {
		curr.y--;
		break;
	    }
	    }

	    Point temp = new Point(0, 0);
	    temp.x = curr.x;
	    temp.y = curr.y;
	    // System.out.println(set);
	    if (set.contains(temp))
		return true;
	    else {
		set.add(temp);
	    }

	}

	return res;
    }

    public static void main(String[] args) {
	for (int i = 0; i < 100; i++) {
	    String s = generate_Input();
	    System.out.println(s);
	}

    }
}
