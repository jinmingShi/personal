public class Solution {
	public int largestSmaller(TreeNode root, int target) {
		int[] res = new int[]{Integer.MIN_VALUE};
		helper(root, target, res);
		return res[0];
	}
	private void helper(TreeNode root, int target, int[] res) {
		if (root == null) {
			return;
		}
		if (target <= root.key) {
			helper(root.left, target, res);
		} else if (target > root.key) {
			res[0] = Math.max(res[0], root.key);
			helper(root.right, target, res);
		}
	}
}