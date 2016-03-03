package medium;

import DataStructures.ListNode;

public class BrightEdge_Add_Two_Number {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode l3 = new ListNode(0);
	ListNode curr = l3;
	ListNode prev = null;
	int carry, sum;
	carry = 0;
	while (l1 != null || l2 != null) {
	    int _temp_sum = 0;
	    if (l2 == null) {
		_temp_sum = l1.val + carry;
		l1 = l1.next;
	    } else if (l1 == null) {
		_temp_sum = l2.val + carry;
		l2 = l2.next;
	    } else {
		_temp_sum = l2.val + l1.val + carry;
		l1 = l1.next;
		l2 = l2.next;
	    }
	    sum = (_temp_sum) % 10;
	    carry = (_temp_sum) / 10;
	    curr.val = sum;
	    if (prev != null)
		prev.next = curr;
	    prev = curr;
	    curr = new ListNode(0);
	}
	if (carry > 0)
	    prev.next = new ListNode(carry);
	return l3;
    }
}
