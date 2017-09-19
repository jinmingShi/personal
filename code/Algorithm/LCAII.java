public class Solution {
	public TreeNodeP LCAII(TreeNodeP node1, TreeNodeP node2) {
		int left = getHeight(node1);
		int right = getHeight(node2);
		while (left > right) {
				node1 = node1.parent;
				left--;
		} 
		while (left < right) {
				node2 = node2.parent;
				right--;
		}
		while (node1 != node2) {
			node1 = node1.parent;
			node2 = node2.parent;
		}
		return node1;
	}
	public int getHeight(TreeNodeP node) {
		TreeNode cur = node;
		int height = 0;
		while (cur != null) {
			cur = cur.parent;
			height++;
		}
		return height;
	}
}