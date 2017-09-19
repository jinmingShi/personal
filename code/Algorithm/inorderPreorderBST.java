public class Solution {
	public TreeNode construct(int[] in, int[] pre) {
		if (int.length == 0) {
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return construct(0, in.length - 1, pre, 0, pre.length - 1, map);
	}
	private TreeNode construct(int in_l, int in_r, 
							   int[] pre, int pre_l, int pre_r, 
							   Map<Integer, Integer> map) {
		if (in_l > in_r) {
			return null;
		}
		TreeNode node = new TreeNode(pre[pre_l]);
		int index = map.get(node.key);
		node.left = construct(n_l, index - 1, 
							  pre, pre_l + 1, pre_l + index - in_l, map);
		node.right = construct(index, in_r, 
			                   pre, pre_l + index - in_l + 1, pre_r, map);
		return node;
	}
}