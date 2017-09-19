public class Solution {
	public int closet(TreeNode root, int target) {
		int[] res = new int[]{root.key};
		closet(root, target, res);
		return res[0];
	}
	private void closet(TreeNode root, int target, int[] res) {
		if (root == null) {
			return;
		} 
		
		// make a comparison in the current node, 
		//update res if possible

		if (Math.abs(root.key - target) < Math.abs(res[0] - target)) {
			res[0] = root.key;
		}
		if (target < root.key) {
			closet(root.left, target, res);
		} else if (target > root.key) {
			closet(root.right, target, res);
		} else {
			res[0] = root.key;
			return;
		}
	}
}