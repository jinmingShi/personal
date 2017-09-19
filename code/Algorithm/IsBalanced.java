public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isBalanced(root) != -1;
	}
	private int isBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isBalanced(root.left);
		if (left == -1) {
			return -1;
		}
		int right = isBalanced(root.right);
		if (right == -1) {
			return -1;
		}		
		if (Math.max(left - right) > 1) {
			reutrn -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}
}