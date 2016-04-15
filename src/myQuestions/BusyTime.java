package myQuestions;

import java.util.*;

public class BusyTime {
	public static int[] busyTime(int[][] log) {
		// 0: time
		// 1: count
		// 2: type
		// type 0=enter
		// type 1=exit
		int[] res = new int[2];
		if (log == null || log.length == 0)
			return null;
		Arrays.sort(log, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return ((Integer) o1[0]).compareTo(o2[0]);
			}
		});
		int n = log.length;

		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < n - 1; i++) {
			if (log[i][2] == 0)
				count += log[i][1];
			else if (log[i][2] == 1)
				count -= log[i][1];
			if (i < n - 1 && log[i][0] == log[i + 1][0])
				continue;
			if (count > maxCount) {
				maxCount = count;
				res[0] = log[i][0];
				if (i < n - 1)
					res[1] = log[i + 1][0];
				else
					res[1] = log[i][0];
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
			log[i][0] = i ;
			log[i][1] = 1+randomGenerator.nextInt(10);
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
		Random randomGenerator = new Random();
		int limit = 20;
		for (int i = 0; i < limit; i++) {
			int[] res = busyTime(generateLog());
//			System.out.println(res[0] + " " + res[1]);
		}
	}
}
