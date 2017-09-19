public class Solution {
	public String removeSpace(String input) {
		if (input.length() == 0) {
			return input;
		}
		int i = 0; 
		int j = 0;
		char[] array = input.toCharArray();
		while (j < array.length) {
			if (array[j] == ' ' && (j == 0 || array[j - 1] == ' ' || j + 1 == array.length) {
				j++;
			} else {
				array[i++] = array[j++];
			}
		}
		if (i > 0 && array[i - 1] == ' ') {
			return new String(array, 0, i - 1);
		}
		return new String(array, 0, i);
	}
}