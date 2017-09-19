public class Solution {
	public List<Integer> zigzag(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int flag = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (flag == 1) {
				for (int i = 0; i < size; i++) {
					TreeNode cur = queue.pollLast();
					if (cur.right != null) {
						queue.offerFirst(cur.right);
					}
					if (cur.left != null) {
						queue.offerFirst(cur.left);
					}
					res.add(cur.key);
				}
				flag = 0;
			} else {
				for (int i = 0; i < size; i++) {
					TreeNode cur = queue.pollFirst();
					if (cur.left != null) {
						queue.offerLast(cur.left);
					}
					if (cur.right != null) {
						queue.offerLast(cur.right);
					}
					res.add(cur.key);
				}
				flag = 1;
			}
		}
		return res;
	}
}