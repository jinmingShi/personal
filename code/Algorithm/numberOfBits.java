public class Solution {
	public int numberOfBit(int a, int b) {
		int res = a ^ b;
		int count = 0;
		int bit = 1;
		for (int i = 1; i <= 32; i++) {
			if (res & bit != 0) {
				count++;
			}
			res >>= 1;
		}
		return count;
	}
}