public class Solution {
	public int[] deDup(int[] array) {
		if (array.length <= 2) {
			return array;
		}
		int left = 2;
		int right = 2;
		while (right < array.length) {
			if (array[right] == array[right - 2]) {
				right++;
			} else {
				array[left++] = array[right++];
			}
		}
		return Arrays.copyOf(array, 0, left);
	}
}