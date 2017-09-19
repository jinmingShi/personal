public class Solution {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int i = 0; 
		int j = 1;
		while (j < input.length()) {
			if (array[i] != array[j]) {
				array[++i] = array[j++];
			}
		}
		return new String(array, 0, i + 1);
	}
}