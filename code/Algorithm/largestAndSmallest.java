public class Solution {
	public int[] largestAndSmallest(int[] array) {
		if (array.length < 1) {
			return array;
		}
		int n = array.length;
		for (int i = 0; i < n / 2; i++) {
			if (array[i] > array[n - i - 1]) {
				swap(array, i, n- i -1);
			}
		}
		int min = array[0];
		for (int i = 0; i <= n / 2; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		int max = array[n / 2];
		for (int i = n / 2; i <= n- 1; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return  new int[]{max, min};
	}
}