public class Solution {
	public TreeNode search(TreeNode root, int k) {
		if (root == null || root.key == k) {
			return root;
		}
		if (root.key > key) {
			return search(root.left, k);
		} else {
			return search(root.right, k);
		}
	}
}