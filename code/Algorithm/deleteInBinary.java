public class Solution {
	public TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (key > root.key) {
			root.right = delete(root.right, key);
		} else if (key < root.key) {
			root.left = delete(root.left, key);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null || root.right == null) {
				return root.left == null ? root.right : root.left;
			} else {
				TreeNode temp = root.left;
				while (temp.right != null) {
					temp = temp.right;
				}
				root.key == temp.key;
				root.left = delete(root.left, temp.key);
			}
		}
		return root;
	}
}