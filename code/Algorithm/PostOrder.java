public class Solution {
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode pre = null;
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if (pre == null || cur == pre.left || cur == pre.right) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					res.add(cur.key);
					stack.pollFirst();
				}
			} else if (pre == cur.left && cur.right == null || pre == cur.right) {
				res.add(cur.key);
				stack.pollFirst();
			} else if (pre == cur.left && cur.right != null) {
				stack.offerFirst(cur.right);
			}
			pre = cur;
		}
		return res;
	}
}