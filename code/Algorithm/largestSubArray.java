public class Solution {
	public int largestSubArray(int[] array) {
		int global_max = 0;
		int cur = 0;
		for (int i = 0; i < array.length; i++) {
			if (cur >= 0) {
				cur += array[i];
				global_max = Math.max(cur, global_max);
			} else {
				cur = array[i];
			}
		}
		return global_max;
	}
}