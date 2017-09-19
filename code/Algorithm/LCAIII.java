public class Solution {
	public TreeNode LCAIII(TreeNode root, List<TreeNode> nodes) {
		if (root == null) {
			return root;
		}
		if (nodes.contains(root)) {
			return root;
		}
		TreeNode left = LCAIII(root.left, nodes);
		TreeNode right = LCAIII(root.right, nodes);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}