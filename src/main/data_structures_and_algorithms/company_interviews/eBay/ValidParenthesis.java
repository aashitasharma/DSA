package data_structures_and_algorithms.company_interviews.eBay;

import java.util.Stack;

//all passed
public class ValidParenthesis{
    public boolean isValid(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    for (Character c : s.toCharArray()) {
	        if ("{([".contains(String.valueOf(c))) {
	            stack.push(c);
	        }else {
	            if (!stack.isEmpty() && isValid(stack.peek(), c)) {
	                stack.pop();
	            }else {
	                return false;
	            }
	        }
	    }
	    
	    return stack.isEmpty();
	}

	public boolean isValid(char c1, char c2) {
	    return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
				|| (c1 == '[' && c2 == ']');
	}
}
