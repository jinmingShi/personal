public class Solution() {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		getRange(root, min, max, res);
		return res;
	}
	private void getRange(TreeNode root, int min, int max, List<Integer> res) {
		if (root == null || root.key > max || root.key < min) {
			return;
		}
		if (root.key > min) {
			getRange(root.left, min, max, res);
		}
		if (root.key >= min && root.key <= max) {
			res.add(root.key);
		}
		if (root.key < max) {
			getRange(root.right, min, max, res);
		}
	}
}