package leetCode.myQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimePlanner {
	public static int[] timePlanner(int dur, int[][] timesA, int[][] timesB) {
		int ia = 0;
		int ib = 0;
		int[] res = new int[2];
		res[0] = Integer.MAX_VALUE;
		res[1] = Integer.MAX_VALUE;
		while (ia < timesA.length && ib < timesB.length) {
			int start = Math.max(timesA[ia][0], timesB[ib][0]);
			int end = Math.min(timesA[ia][1], timesB[ib][1]);
			if (start + dur <= end) {

				res[0] = start;
				res[1] = start + dur;
				return res;
			} else {
				if (timesA[ia][1] < timesB[ib][1])
					ia = ia + 1;
				else
					ib = ib + 1;
			}
		}
		return res;
	}

	public static int[][] generateLog() {
		Random randomGenerator = new Random();
		int limit = 1 + randomGenerator.nextInt(10);
		int[][] log = new int[limit][3];
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		for (int i = 0; i < limit; i++) {
			log[i][0] = i;
			log[i][1] = 1 + randomGenerator.nextInt(10);
			log[i][2] = randomGenerator.nextInt(2);
			// System.out.println(log[i][0] + " " + log[i][1] + " " +
			// log[i][2]);
		}

		int index;
		Random random = new Random();
		for (int i = limit - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			if (index != i) {
				log[index][0] ^= log[i][0];
				log[i][0] ^= log[index][0];
				log[index][0] ^= log[i][0];
			}
		}
		for (int i = 0; i < limit; i++) {
			List<Integer> sublist = new ArrayList<Integer>();
			sublist.add(log[i][0]);
			sublist.add(log[i][1]);
			sublist.add(log[i][2]);
			l.add(sublist);
		}
		System.out.println(l);
		return log;
	}

	public static void main(String[] args) {
		int[][] ta = { { 3, 5 }, { 6, 8 } };
		int[][] tb = { { 4, 6 }, { 7, 8 } };
		int[] r = timePlanner(1, ta, tb);
		System.out.println(r[0] + " " + r[1]);
	}
}
