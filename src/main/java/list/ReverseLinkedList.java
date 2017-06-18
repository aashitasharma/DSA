package leetCode.easy;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
	if (head != null) {
	    ListNode temp, next_node;
	    next_node = head.next;
	    head.next = null;
	    while (next_node != null) {
		temp = next_node;
		next_node = temp.next;
		temp.next = head;
		head = temp;
	    }
	    return head;
	} else
	    return null;
    }

}
