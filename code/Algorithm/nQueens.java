public class Solution {
	private boolean valid(List<Integer> cur, int row, int column) {
		for(int i = 0; i < cur.size(); i++) {
			if(cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
				return false;
			}
		}
			return true;
	}
	public List<List<Integer>> nqueen(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<>();
		nqueen(n, 0, cur, res);
		return res;
	}
	private void nqueen(int n, int index, List<Integer> cur, List<List<Integer>> res) {
		if (index == n) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (valid(cur, index, i)) {
				cur.add(i);
				nqueen(n, index + 1, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}
}