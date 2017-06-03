package leetCode.myQuestions;

import java.util.Random;
import java.util.*;

public class FlightPlanner {

	public static int SEED = 100;

	public FlightPlanner() {

	}

	public static List<Integer> testCasesGen() {
		Random randomGenerator = new Random();
		List<Integer> testCases = new ArrayList<Integer>();
		int i = 0;
		int limit = randomGenerator.nextInt(SEED);
		while (i < limit) {
			i++;
			testCases.add(randomGenerator.nextInt(SEED));
		}
		return testCases;
	}

	public static void main(String[] args) {

		Random randomGenerator = new Random();
		int notc = randomGenerator.nextInt(500);
		int[] output = new int[notc];
		for (int i = 0; i < notc; i++) {
			List<Integer> tc = testCasesGen();
			// output[i]=calculateFuel(tc);
			System.out.println(testCasesGen());
		}
		// for(int i:output)
		// System.out.println(i);
	}

	public static int calculateFuel(List<Integer> route) {
		if (route.size() == 0)
			return 0;
		int maxHeight = route.get(0);
		for (int i = 1; i < route.size(); i++) {
			maxHeight = Math.max(route.get(i), maxHeight);
		}
		return maxHeight - route.get(0);
	}
}
