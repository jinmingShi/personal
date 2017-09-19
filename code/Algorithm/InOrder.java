public class Solution {
	public List<Integer> inorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.offerFirst(root);
				root = root.left;
			} else {
				root = stack.pollFirst();
				res.add(root.key);
				root = root.right;
			}
		}
		return res;
	}
}