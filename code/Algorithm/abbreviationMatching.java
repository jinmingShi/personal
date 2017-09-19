public class Solution {
	public boolean match(String input, String pattern) {
		if (pattern.length() == 0) {
			return true;
		}
		char[] array = pattern.toCharArray();
		int p = 0;
		int index = 0;
		while (p < array.length) {
			if (array[p] >= 'a' && array[p] <= 'z') {
				if (array[p] != input.charAt(index)) {
					return false;
				}
				index++;
				p++;
			} else {
				int n = 0;
				while (p < array.length && array[p] >= '0' && array[p] <= '9') {
					n = n * 10 + array[p] - '0';
					p++;
				}
				index += n;

			}
			if (index > input.length()) {
				return false;
			}
		}
		if (index != input.length()) {
			return false;
		}
		return true;
	}
}