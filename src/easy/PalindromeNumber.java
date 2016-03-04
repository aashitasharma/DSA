package easy;

public class PalindromeNumber {
    public boolean isPalindrome(int n) {

	long x = n;
	if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE || x < 0)
	    return false;
	int d = digits(x) - 1;
	int high = (int) Math.pow(10, d);
	while (x >= 1) {
	    int right = (int) x / high;
	    int left = (int) x % 10;
	    // /System.out.println(right+" "+left);
	    if (right != left)
		return false;
	    x = (x - right * high) / 10;
	    d -= 2;
	    high = (int) Math.pow(10, d);
	}
	return true;

    }

    public int digits(long x) {
	int d = 0;
	while (x >= 1) {
	    x = x / 10;
	    d++;
	}
	return d;

    }

}
