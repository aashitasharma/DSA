/**
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
**/

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      LinkedList<ListNode> s1 = getStackFromList(l1);
      LinkedList<ListNode> s2 = getStackFromList(l2);
      LinkedList<Integer> s3 = new LinkedList<Integer>();
      int carry = 0;
      while(!s1.isEmpty() && !s2.isEmpty()){
        int sum = s2.pop().val + s1.pop().val + carry;
        carry = sum/10;
        s3.push(sum%10);
      }
      carry = addRemaining(s2, s3, carry);
      carry = addRemaining(s1, s3, carry);
      if(carry > 0){
          s3.push(carry);
      }
      return getListFromStack(s3);
  }

  LinkedList<ListNode> getStackFromList(ListNode node){
    LinkedList<ListNode> s1 = new LinkedList<ListNode>();
    while(node != null){
      s1.push(node);
      node=node.next;
    }
    return s1;
  }

  ListNode getListFromStack(LinkedList<Integer> l){
      ListNode l3 = new ListNode(0);
      ListNode temp = l3;
      int k = l.size();
      while(l.size()>1){
          temp.val = l.pop();
          temp.next = new ListNode(0);
          temp = temp.next;
      }
      temp.val = l.pop();
      return l3;
  }

  int addRemaining(LinkedList<ListNode> s, LinkedList<Integer> newList, int carry) {
    while(!s.isEmpty()){
        int sum = s.pop().val + carry;
        carry = sum/10;
        newList.push(sum%10);
    }
    return carry;
  }
}
