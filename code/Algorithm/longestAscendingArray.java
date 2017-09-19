public class Solution {
	public int longestAscendingArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int index = 0;
		int global = 1;
		int cur = 1;
		while (index < array.length) {
			if (index + 1 < array.length && array[index] < array[index + 1]) {
				cur++;
				global = Math.max(global, cur);
			} else {
				cur = 1;
			}
			index++
		}
		return global;
	}
}