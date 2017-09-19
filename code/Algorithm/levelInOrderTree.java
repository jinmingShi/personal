public class Solution {
	public TreeNode construct(int[] in, int[] level) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return construct(0, in.length - 1, level, map);
	}
	private TreeNode construct(int in_l, int in_r, int[] le, Map<Integer, Integer> map) {
		if (in_l > in_r) {
			return null;
		}
		TreeNode node = new TreeNode(le[0]);
		int index = map.get(node.key);
		int[] level_left = new int[index - in_l];
		int m = 0;
		int[] level_right = new int[in_r - index];
		int n = 0;
		for (int i = 1; i <= le.length - 1, i++) {
			int pos = map.get(le[i]);
			if (pos < index) {
				level_left[m++] = le[i]
			} else {
				level_right[n++] = le[i];
			}
		}
		node.left = construct(in_l, index - 1, level_left, map);
		node.right = construct(index + 1, in_r, level_right, map);
		return node;
	}
}