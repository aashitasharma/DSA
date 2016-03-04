package data_structures;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public Lists() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode l2=new ListNode(1);
		head.next=l2;
		ListNode l3=new ListNode(3);
		l2.next=l3;
		ListNode l4=new ListNode(5);
		l3.next=l4;
		ListNode l5=new ListNode(6);
		l4.next=l5;
		ListNode l6=new ListNode(2);
		l5.next=l6;
		ListNode l7=new ListNode(7);
		l6.next=l7;
		ListNode l8=new ListNode(9);
		l7.next=l8;
		ListNode l9=new ListNode(8);
		l8.next=l9;
		
		
		List<ListNode> p=new ArrayList<ListNode>();
		ListNode temp=head;
		while(temp!=null){
			p.add(temp);
			temp=temp.next;
		}
		
		p.get(3).next=null;
		
		temp=head;
		while(temp!=null){
			System.out.println(temp.val);
			temp=temp.next;
		}
	
	}

	public static ListNode detectCycle(ListNode head) {
		ListNode one = head;
		ListNode two = head.next;
		while (two != null && one != null) {
			if (one == two)
				return one;
			one = one.next;
			if (two.next != null)
				two = two.next.next;
			else
				return null;
		}
		return null;
	}
	
	public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newhead, newtail, newcurr, newprev, curr;
        newprev=null;
        curr=head.next;
        newhead=newtail=head;
        newcurr=newhead;
        newtail.next=null;
        while(curr!=null){
            if(curr.val < newhead.val){
                newprev=newhead;
                newhead=curr;
                curr=curr.next;
                newhead.next=newprev;
            }
            else if(curr.val > newtail.val){
                newtail.next=curr;
                newtail=curr;
                curr=curr.next;
                newtail.next=null;
                
            }
            else{
            newcurr=newhead;
            while(newcurr!=null && curr.val >= newcurr.val ){
                newprev=newcurr;
                newcurr=newcurr.next;
            }
            newprev.next=curr;
            curr=curr.next;
            newprev.next.next=newcurr;    
            }   
        }
        return newhead;
        
    }
}