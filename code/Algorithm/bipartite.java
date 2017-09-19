public class Solution {
	public boolean isBipartite(List<GraphNode> graph) {
		HashMap<GraphNode, Integer> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				Deque<GraphNode> queue = new ArrayDeque<>();
				queue.offerFirst(node);
				int group = 0;
				map.put(node, group);
				while (!queue.isEmpty()) {
					GraphNode cur = queue.pollLast();
					int groupId = map.get(cur);
					for (GraphNode nei : cur.neighbors) {
						if (!map.containsKey(nei)) {
							int neiId = groupId == 0 ? 1 : 0;
							map.put(nei, neiId);
							queue.offer(nei);
						} else {
							if (map.get(nei) == groupId) {
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
class GraphNode {
	int key;
	List<GraphNode> neighbors;

	public GraphNode(int val) {
		this.key = key;
	}
}