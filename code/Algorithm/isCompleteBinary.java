public class Solution {
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return true;
		}
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offerFirst(root);
		boolean flag = false;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.pollLast();
			if (cur.left == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offerFirst(cur.left);
			}
			if (cur.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				queue.offerFirst(cur.right);
			}
		}
		return true;
	}
}