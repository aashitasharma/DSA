package data_structures_and_algorithms.leetCode.hard;

import data_structures_and_algorithms.data_structures.ListNode;

public class ReverseNodesKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1)
        	return head;
        int rem_nodes=0;
        ListNode temp=head;
        while(temp!=null){
        	temp=temp.next;
        	rem_nodes+=1;
        }
        return reverseGroup(head, k, rem_nodes);  	
    }
	public ListNode reverseGroup(ListNode start, int k, int rem){
		if(k>rem || start.next==null){
			return start;
		}
		else{
			ListNode curr, prev, next;
			curr=start;
			prev=null;
			next=start.next;
			int count=0;
			while(count<k){
				curr.next=prev;
				prev=curr;
				curr=next;
				next=curr.next;
				count++;
			}
			start.next=reverseGroup(curr, k, rem-k);
			return prev;
		}
	}
	
}
