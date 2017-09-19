public class Solution {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		maxPathSum(root, max);
		return max;
	}
	private int maxPathSum(TreeNode root, int[] max) {
		if (root == null) {
			return 0;
		}
		int left = maxPathSum(root.left, max);
		int right = maxPathSum(root.right, max);
		left = left > 0 ? left : 0;
		right = right > 0 ? right : 0;
		max[0] = Math.max(max[0], left + right + root.key);
		return left > right ? left + root.key : right + root.key;
	}
}