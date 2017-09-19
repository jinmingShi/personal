public class Solution {
	public int minJump(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int[] M = new int[array.length];
		M[array.length - 1] = 0;
		for (int i = array.length - 2; i>= 0; i--) {
			M[i] = -1;
			if (array[i] + i >= array.length - 1) {
				M[i] = 1;
			} else {
				int min = Integer.MAX_VALUE:
				for (int j = array[i]; j >= 1; j--) {
					if (M[i + j] != -1) {
						min = Math.min(min, M[i + j]);
					}
				}
				if (min != Integer.MAX_VALUE) {
					M[i] = 1 + min;
				}
			}
		}
		return M[0];
	}
}