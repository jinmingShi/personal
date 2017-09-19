public class Solution {
	public int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		maxPathSum(root, 0, max);
		return max[0];
	}
	private int maxPathSum(TreeNode root, int prefix_sum, int[] max) {
		if (root == null) {
			return 0;
		}
		prefix_sum = prefix_sum > 0 ? prefix_sum : 0;
		max[0] = Math.max(max[0], max[0] + root.key);
		maxPathSum(root.left, prefix_sum + root.key, max);
		maxPathSum(root.right, prefix_sum + root.key, max);
	}
}