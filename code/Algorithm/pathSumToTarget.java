public class Solution {
	public boolean exist(TreeNode root, int target) {
		Set<Integer> sums = new HashSet<>();
		return exist(root, target, 0, sums);
	}
	private boolean exist(TreeNode root, int target, int sum, Set<Integer> sums) {
		if (root == null) {
			return false;
		}
		sums.add(sum);
		if (sums.contains(sum + root.key - target)) {
			return true;
		}
		boolean left;
		if (root.left != null) {
			left = exist(root.left, target, root.key + sum, sums); 
		}
		boolean right;
		if (root.right != null) {
			right = exist(root.right, target, root.key + sum, sums);
		}
		sums.remove(sum);
		return left || right;
	}
	// Suggested by standard answer:
	public boolean existII(TreeNode root, int target, int sum, Set<Integer> sums) {
		sum += root.key;
		if (sums.contains(sum - target)) {
			return true;
		}
		boolean needed = sums.add(sum);
		if (root.left != null && existII(root.left, target, sum, sums)) {
			return true;
		}
		if (root.right != null && existII(root.right, target, sum, sums)) {
			return true;
		}
		if (needed) {
			sums.remove(sum);
		}
		return false;
	}
}


