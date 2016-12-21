package data_structures_and_algorithms.leetCode.hard;

import data_structures_and_algorithms.data_structures.ListNode;

public class MergeKLists {
	
	
	
	public ListNode merge2List(ListNode l1, ListNode l2){
		ListNode head=new ListNode(0);
		ListNode l3=head;
		while(l1!=null && l2!=null){
			if(l1.val==l2.val){
				l3.next=l1;
				l1=l1.next;
				l2=l2.next;
			}else if(l1.val<l2.val){
				l3.next=l1;
				l1=l1.next;
			}else{
				l3.next=l2;
				l2=l2.next;
			}
			l3=l3.next;
		}
		l3.next=(l1!=null)?l1:l2;
		return head.next;
	}
	
	public ListNode mergekList(ListNode[] l, int s, int e){
		if(s>e)
			return null;
		if(s==e)
			return l[e];
		int m=s+(e-s)/2;
		ListNode a=mergekList(l, s, m);
		ListNode b=mergekList(l, m+1, e);
		return merge2List(a, b);
	}
}

