package hard;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
	if(p.equals("") && s.equals(""))
	    return true;
	else if(p.equals("") && !s.equals(""))
	    return false;
	int pp = 0;
	int sp = 0;
	while (pp < p.length() && sp < s.length()) {
	    char pc = p.charAt(pp);
	    char sc = s.charAt(sp);
	    if (pc != '?' && pc != '*' && pc != sc)
		return false;
	    else {
		if (pc == sc || pc == '?') {
		    pp++;
		    sp++;
		} else if (pc == '*') {
		    sp++;
		    if (pp == p.length() - 1)
			return true;
		    if(sp==s.length())
			return false;
		  
		    else {
			if (p.charAt(pp + 1) == s.charAt(sp))
			    pp++;
		    }
		}
	    }

	}

	if (pp == p.length() && sp == s.length())
	    return true;
	else
	    return false;
    }
    public static void main(String[] args){
	
//	String[] pattern={"g*k", "?*", "*","a*","abefcdgiescdfimde"};
//	String[] s=	 {"gee", "ab", "ab", "aa","ab*cd?i*de"};
//	for(int i=0;i<pattern.length;i++)
//	    System.out.println(i+" "+isMatch(s[i], pattern[i]));
	System.out.println(isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
	
    }

}
