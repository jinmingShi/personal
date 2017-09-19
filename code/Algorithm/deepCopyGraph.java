public class Solution {
	public List<GraphNode> copy(List<GraphNode> graph) {
		List<GraphNode> list = new ArrayList<>();
		HashMap<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode cur : graph) {
			GraphNode node;
			if (!map.containsKey(cur)) {
				node = new GraphNode(cur.key);
				map.put(cur, node);
			}
			node = map.get(cur);
			for (GraphNode nei : cur.neighbors) {
				if (!map.containsKey(nei)) {
					GraphNode neiNode = new GraphNode(nei.key);
					map.put(nei, neiNode);
				}
				node.neighbors.add(map.get(nei));
			}
			list.add(node);
		}
		return list;
	}
}