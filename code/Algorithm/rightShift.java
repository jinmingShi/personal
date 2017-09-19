public class Solution {
	public String rightShift(String input, int n) {
		if (input.length() == 0 || n == 0) {
			return input;
		}
		n %= input.length();
		char[] array = input.toCharArray();
		swap(array, 0, array.length - n - 1);
		swap(array, array.length - n, array.length - 1);
		swap(array, 0, array.length - 1);
		return new String(array);
	}
	private void swap(cahr[] array, int left, int right) {
		while (left < right) {
			char ch = array[left];
			array[left] = array[right];
			array[right] = ch;
			left++;
			right--;
		}
	}
}