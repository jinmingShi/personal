public class Solution {
	public String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			if (array[fast] != null && (fast == 0 || array[fast - 1] == ' ')) {
				slow = fast;
			} else if (array[fast] != null && (fast + 1 == array.length || array[fast + 1] == ' ')) {
				swap(array, slow, fast);
			}
			fast++;
		}
		swap(array, 0, array.length - 1);
		return new String(array);
	}
	private void swap(char[] a, int i, int j) {
		while (i < j) {
			char ch = a[i];
			a[i] = a[j];
			a[j] = ch;
			i++;
			j--;
		}
	}
}