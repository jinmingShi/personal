public class Solution {
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		TreeNode pre = root;
		insert(root, pre, key);
		return root;
	}
	private void insert(TreeNode root, TreeNode pre, int key) {
		if (root == null) {
			if (key < pre.key) {
				pre.left = new TreeNode(key);
			} else {
				pre.right = new TreeNode(key);
			}
		}
		if (key > root.key) {
			insert(root.right, root, key);
		} else if (key < root.key) {
			insert(root.left, root, key);
		} else {
			return;
		}
	}
}

public class Solution {
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		helper(root, key);
		return root;
	}
	public TreeNode helper(TreeNode root, int key) {
		if (root == null ) {
			return new TreeNode(key);
		}
		if (key < root.key) {
			root.left = helper(root.left, key);
		} else if (key > root.key) {
			root.right = helper(root.right, key);
		}
		return root;
	}
}