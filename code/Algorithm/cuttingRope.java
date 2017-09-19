public class Solution {
	public int maxCut(int n) {
		int[] M = new int[n + 1];
		M[0] = 0;
		M[1] = 0;
		for (int i = 1; i <= n; i++) {
			int max = 0;
			for (int j = 1; j < i; j++) {
				max = Math.max(Math.max(j, M[j]) * (i - j), max);
			}
			M[i] = max;
		}
		return M[n];
	}
}