package interview;
import java.util.Arrays;
import java.util.Scanner;

public class WallmartLabs {

    public WallmartLabs() {
	// TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

	// int[] a = readInput();
	System.out
		.println(zeros(2123423423));
    }

    public static int[] readInput() {
	Scanner in = new Scanner(System.in);
	int _a_size = Integer.parseInt(in.nextLine());
	int[] _a = new int[_a_size];
	int _a_item;

	for (int _a_i = 0; _a_i < _a_size; _a_i++) {
	    _a_item = Integer.parseInt(in.nextLine());
	    _a[_a_i] = _a_item;
	}
	return _a;

    }

    private static int countMinCandies(int[] ratings) {
	int[] candies = new int[ratings.length];
	Arrays.fill(candies, 1);

	for (int i = 0; i < candies.length;) {
	    if (i > 0 && ratings[i] > ratings[i - 1]
		    && candies[i] <= candies[i - 1]) {
		candies[i] = candies[i - 1] + 1;
		i--;
	    }

	    else

	    if (i < candies.length - 1 && ratings[i] > ratings[i + 1]
		    && candies[i] <= candies[i + 1]) {
		candies[i] = candies[i + 1] + 1;
		if (i > 0)
		    i--;
	    }

	    else
		i++;
	}

	int totalCandies = 0;
	for (int c : candies) {
	    totalCandies += c;
	}

	return totalCandies;
    }

    public static String parity(String msg) {
	String p = null;
	int n = msg.hashCode();
	switch (n % 2) {
	case 0:
	    p = "even";
	    break;
	case 1:
	    p = "odd";
	    break;
	}
	return p;
    }

    public Boolean isTwoPower(int n) {
	if ((n != 0) && (n & (n - 1)) == 0)
	    return true;
	else
	    return false;
    }

    public static long zeros(long n){
	long count=0;
	int i=1;
	long tempn=n;
	while(n>0){
	    long temp=(long) (tempn/Math.pow(5, i++));
	    count+=temp;
	    n=temp;
	}
	return count;
    }
    
}
