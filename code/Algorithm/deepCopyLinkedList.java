public class Solution {
	public RandomListNode copy(RandomListNode head) {
		if (head == null) {
			return head;
		}
		HashMap<RandomListNode node, RandomListNode dup> map = new HashMap<>();
		RandomListNode cur = head;
		RandomListNode pre = null;
		while (cur != null) {
			RandomListNode node;
			if (!map.containsKey(cur)) {
				node = new RandomListNode(cur.value);
				map.put(cur, node);
			}
			node = map.get(cur);
			if (pre != null) {
				pre.next = node;
			}
			if (cur.random != null) {
				if (!map.containsKey(cur.random)) {
					RandomListNode random = new RandomListNode(cur.random.value);
					node.random = random;
					map.put(cur.random, random);
				}
				node.random = map.get(cur.random);
			}
			pre = node;
			cur = cur.next;
		}
		return map.get(head);
	}
}