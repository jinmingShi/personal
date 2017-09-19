public class Solution {
	public int missing(int[] array) {
		int n = array.length + 1;
		int xor = 1;
		for (int i = 2; i <= n; i++) {
			xor = xor ^ i;
		}
		for (int i : array) {
			xor ^= i;
		}
		return xor;
	}
}