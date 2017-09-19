public class Solution {
	public ListNode merge(List<ListNode> listOfLists) {
		ListNode newHead = new ListNode(0);
		ListNode cur = newHead;
		if (listOfLists.size() == 0) {  // listOfLists could be empty although
			return cur.next;			// it is not NULL!
		}
		PriorityQueue<ListNode> heap = new PriorityQueue<>(listOfLists.size(), 
			new Comparator<ListNode>() {
				public int compare(ListNode n1, ListNode n2) {
					if (n1.val == n2.val) {
						return 0;
					}
					return n1.val < n2.val ? -1 : 1;
				}
			}); 

		for (ListNode node : listOfLists) {
			if (node != null) {
				heap.offer(listOfLists.get(i));		
			}
		}
		while (!listOfLists.isEmpty()) {
			ListNode node = heap.poll();
			if (node.next != null) {
				heap.offer(node.next);
			}
			cur.next = node;
			cur = cur.next;
		}
		return newHead.next;
	}
}