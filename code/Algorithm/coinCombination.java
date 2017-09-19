public class Solution {
	public List<List<Integer>> combination(int k, int[] coins) {
		List<List<Integer>> res = new ArrayList<List<Integer>>;
		List<Integer> list = new ArrayList<>();
		combination(coins, k, 0, res, list);
		return res;
	}
	private void combination(int[] coins, int target, int level, List<List<Integer>> res, List<Integer> list) {
		if (level == coins.length - 1) {
			if (target % coins[level] == 0) {
				list.add(target / coins[level]);
				res.add(new ArrayList<Integer>(list));
				list.remove(list.size() - 1);
				return;
			}
		}
		for (int i = 0; i <= target / coins[level]; i++) {
			list.add(i);
			combination(coins, target - i * coins[level], level + 1, res, list);
			list.remove(list.size() - 1);
		}
	}

}