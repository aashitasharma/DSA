package leetCode.easy;

class MinStack{
	ListNode head;
	ListNode tail;
	int size;
	int min=Integer.MAX_VALUE;
	public void push(int x){
		ListNode newnode=new ListNode(x);
		if(tail==null){
			head=newnode;
			tail=newnode;
			min=newnode.val;
		}
		else{
			tail.next=newnode;
			newnode.prev=tail;
			tail=newnode;
			if(min>newnode.val)
				min=newnode.val;
		}
		size++;
	}
	public ListNode pop(){
		if(tail==null){
			size--;
			return null;
		}
		else{
			ListNode lastNode=tail;
			if(head==tail){
				head=null;
				tail=null;
				min=Integer.MIN_VALUE;
			}
			else{
				tail=tail.prev;
				tail.next=null;
			}
			size--;
			if(lastNode.val==min){
				min=Integer.MAX_VALUE;
				ListNode temp=head;
				while(temp!=null){
					if(min>temp.val)
						min=temp.val;
					temp=temp.next;
				}
			}
			return lastNode;
		}
	}

	public int getMin(){
		return min;
	}

	public int top(){
		return tail.val;
	}

	public boolean isEmpty(){
		if(size==0)
			return true;
		else
			return false;
	}
	@Override
	public String toString(){
		StringBuilder sb=new StringBuilder();
		ListNode temp=head;
		while(temp.next!=null){
			sb.append(temp.val).append("->");
			temp=temp.next;
		}
		sb.append(temp.val);
		return sb.toString();
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode prev;
	public ListNode(int x){
		val=x;
	}
}