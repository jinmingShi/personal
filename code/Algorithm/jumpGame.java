public class Solution {
	public boolean canJump(int[] array) {
		if (array.length == 1) {
			return true;
		}
		boolean[] M = new boolean[array.length];
		M[array.length - 1] = true;
		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] + i >= array.length - 1) {
				M[i] = true;
			} else {
				for (int j = 1; j <= array[i]; j++) {
					if (M[i + j]) {
						M[i] = true;
						break;
					}
				}

			}
		}
		return M[0]; 
	}
}