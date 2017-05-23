package data_structures_and_algorithms.leetCode.hard;

import java.util.*;

public class CopyRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode oldhead = head;
		RandomListNode newhead = new RandomListNode(0);
		RandomListNode temp = newhead;
		while (oldhead != null) {
			temp.next = new RandomListNode(oldhead.label);
			map.put(oldhead, temp.next);
			oldhead = oldhead.next;
			temp=temp.next;
		}
		oldhead=head;
		temp=newhead.next;
		while (oldhead != null) {
			RandomListNode random=oldhead.random;
			temp.random=map.get(random);
			oldhead=oldhead.next;
			temp=temp.next;
		}
		return newhead.next;
	}
}
