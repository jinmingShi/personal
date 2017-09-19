public class Solution {
	public int maxPathSum(TreeNode root) {
		int[] a = new int[1];
		a[0] = Integer.MIN_VALUE;
		maxPathSum(root, a);
		return a[0];
	}
	private int maxPathSum(TreeNode root, int[] a) {
		if (root == null) {
			return 0;
		}
		int left = maxPathSum(root.left, a);
		int right = maxPathSum(root.right, a);
		if (root.left != null && root.right != null) {
			a[0] = Math.max(a[0], left + right + root.key);
			return left > right ? left + root.key : right + root.key;
		} else if (root.left == null && root.right == null) {
			return root.key;
		} else {
			return root.key == null ? right + root.key : left + root.key;
		}
	}
}