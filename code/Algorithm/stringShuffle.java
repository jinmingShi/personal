public class Solution {
	public int[] shuffle(int[] input) {
		if (input.length <= 1) {
			return input;
		}
		if (input.length % 2 == 0) {
			shuffle(input, 0, input.length - 1);
		} else{
			shuffle(input, 0, input.length - 2);
		}
		return input;
	}
	private void shuffle(int[] input, int left, int right) {
		if (right - left <= 1) {
			return;
		}
		int size = right - left + 1;
		int mid = left + size / 2;
		int left_mid = left + size / 4;
		int right_mid = left + size * 3 / 4;
		swap(input, left_mid, mid - 1);
		swap(input, mid, right_mid - 1);
		swap(input, left_mid, right_mid - 1);
		shuffle(input, left, left + 2 * (left_mid - left) - 1);
		shuffle(input, left + 2 * (left_mid - left), right);
	}
	private void swap(int[] array, int left, int right) {
		while (left < right) {
			int ch = array[left];
			array[left] = array[right];
			array[right] = ch;
			left++;
			right--;
		}
	}
}