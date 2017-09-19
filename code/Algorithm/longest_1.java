public class Solution {
	public int longestConsecutive(int[] array) {
		int global = 0;
		int cur = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				cur++;
				global = Math.max(global, cur);
			} else {
				cur = 0;
			}
		}
	}
}