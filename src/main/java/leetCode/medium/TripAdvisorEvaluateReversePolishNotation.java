package leetCode.medium;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Used Regex, but could be done without it as well.
 * @author Ankit
 *
 */
public class TripAdvisorEvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

	int res = 0;
	try {
	    res = Integer.parseInt(tokens[0]);
	} catch (NumberFormatException n) {
	    System.out.println("Invalid Input");
	}
	LinkedList<Integer> stack = new LinkedList<Integer>();
	for (String s : tokens) {
	    if (isOperand(s)) {
		int op2 = stack.poll();
		int op1 = stack.poll();
		res = evaluate(op1, op2, s);
		stack.add(res);
	    } else {
		try {
		    stack.add(Integer.parseInt(s));
		} catch (NumberFormatException ne) {
		    System.out.println("Invalid Input");
		}

	    }
	}
	// System.out.println(res);
	return res;
    }

    public static boolean isOperand(String s) {
	Pattern p = Pattern.compile("[*+-/]");
	Matcher m = p.matcher(s);
	return m.matches();
    }

		// TODO: fix this
    public static int evaluate(int op1, int op2, String op) {
//	switch (op) {
//	case "+":
//	    return op1 + op2;
//	case "-":
//	    return op1 - op2;
//	case "*":
//	    return op1 * op2;
//	case "/":
//	    return op1 / op2;
//	}
	return 0;
    }

}
