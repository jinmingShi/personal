public class Solution {
	public TreeNode construct(int[] post) {
		if (post.length == 0) {
			return null;
		}
		return construct(post, 0, post.length - 1);
	}
	private TreeNode construct(int[] post, int left, int right) {
		if (left > right) {
			return null;
		}
		
		// This situation could be ignored, because
		// when left == right, we can still create new node form the range 
		// then narrow the range of the array, continue to create its left and right 
		// node.

		if (left == right) {
			return new TreeNode(post[left]);
		}
		TreeNode node = new TreeNode(post[right]);
		int index = left;
		while (post[index] < post[right]) {
			index++;
		}
		node.left = construct(post, left, index - 1);
		node.right = construct(post, index, right - 1);
		return node;
	}
}