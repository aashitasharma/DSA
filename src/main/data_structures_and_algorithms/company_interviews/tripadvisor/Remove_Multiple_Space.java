package data_structures_and_algorithms.company_interviews.tripadvisor;

/*
 Given " I love    this game    !    ",return " I love this game ! "
 */

//Time Complexity : O(n)
//Space Complexity : O(1)

public class Remove_Multiple_Space {
    public static void main(String[] args) {
	System.out.println(removeMulSpace("  "));
    }

    public static String removeMulSpace(String origin) {
	if (origin == null || origin.isEmpty()) {
	    return origin;
	}

	StringBuilder sb = new StringBuilder();
	boolean flag=true;
	for (int curr = 0; curr < origin.length(); curr++) {
	    char ch=origin.charAt(curr);
	    if (ch==' ' && flag){
		sb.append(ch);
		flag=false;
	    }
	    else if (ch!=' '){
		sb.append(ch);
		flag=true;
	    }
	}
	return sb.toString();
    }
    
}