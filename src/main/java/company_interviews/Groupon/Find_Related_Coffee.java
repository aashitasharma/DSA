package company_interviews.Groupon;

import java.util.*;

//given object class
class Coffee {

}

// given function

// helper class to match coffee and similarity score
class Pair implements Comparator<Pair> {
    Coffee coffee;
    double score;

    Pair(Coffee c, double s) {
	coffee = c;
	score = s;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
	// TODO Auto-generated method stub
	return (int) (o1.score - o2.score);
    }
}

public class Find_Related_Coffee {

    public double getScore(Coffee A, Coffee B) {
	return 0.0;
    }

    public List<Coffee> getTopK(List<Coffee> menu, Coffee A, int size) {
	List<Pair> scorelist = new ArrayList<Pair>();

	// O(n) to get similarity score
	for (Coffee c : menu) {
	    Pair p = new Pair(c, getScore(A, c));
	    scorelist.add(p);
	}

	final int recommendationSize = size;
	PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(
		recommendationSize);

	// O(nlogk) k = size to get the top k for minHeap
	for (Pair p : scorelist) {
	    minHeap.offer(p);
	    if (minHeap.size() >= recommendationSize + 1) {
		minHeap.poll();
	    }
	}

	// O(1) size is constant to add coffee to result list
	List<Coffee> result = new ArrayList<Coffee>();
	for (Pair p : minHeap) {
	    result.add(p.coffee);
	}

	return result;
    }

}
