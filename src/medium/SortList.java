package medium;

import data_structures.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		ListNode end=head;
		while(end.next!=null)
			end=end.next;
		return sortList(head, end);		
	}

	public ListNode sortList(ListNode start, ListNode end) {
		if(start==null || start==end)
			return start;
		ListNode mid=getMid(start);
		ListNode temp=mid.next;
		mid.next=null;
		ListNode a= sortList(start, mid);
		ListNode b= sortList(temp, end);
		return merge2List(a,b);
	}

	public ListNode merge2List(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l3 = head;
		while (l1 != null && l2 != null) {
			if (l1.val == l2.val) {
				l3.next = l1;
				l1 = l1.next;
				l2 = l2.next;
			} else if (l1.val < l2.val) {
				l3.next = l1;
				l1 = l1.next;
			} else {
				l3.next = l2;
				l2 = l2.next;
			}
			l3 = l3.next;
		}
		l3.next = (l1 != null) ? l1 : l2;
		return head.next;
	}

	public ListNode getMid(ListNode start) {
		ListNode fast = start.next;
		while (fast!=null && fast.next!=null) {
			start = start.next;
			fast = fast.next.next;
		}
		return start;

	}
}
