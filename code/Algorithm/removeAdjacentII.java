public class Solution {
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] a = input.toCharArray();
		int left = 0;
		for (int i = 1; i < a.length; i++) {
			if (left == -1 || a[left] != a[i]) {
				a[++left] = a[i];
			} else {
				left--;
				while (i + 1 < a.length && a[i] == a[i + 1]) {
					i++;
				}
			}
		}
		return new String(a, 0, left + 1);
	}
}