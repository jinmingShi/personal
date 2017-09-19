class ListNode {
	int value;
	ListNode next;

	public ListNode(int val) {
		this.value = val;
		next = null;
	}
}
public class Solution {
	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = reversePairs(head.next.next);	
		head.next.next = head;
		ListNode newHead = head.next;
		head.next = next;
		return newHead;
	}
	public ListNode reverseInPairsII(ListNode head) {
		if (head == null || head.next == null) {	
			return head;
		}
		ListNode pre = null; 
		ListNode newHead = head.next;
		while (head != null && head.next != null) {
			ListNode temp = head.next.next;
			if (pre != null) {
				pre.next = head.next;
			}
			head.next.next = head;
			head.next = temp;
			pre = head;
			head = temp;
		}
		if (head != null) {
			pre.next = head;
		}
		return newHead;
	}
}




