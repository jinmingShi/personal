public class Solution {
	public String stringReplace(String input, String s, String t) {
		char[] array = input.toCharArray();
		if (s.length() > t.length()) {
			return replaceShort(array, s, t);
		} else {
			return replaceLarge(array, s, t);
		}
	}
	private String replaceShort(char[] array, String s, String t) {
		int left = 0;
		for (int i = 0; i < array.length; i++) {
			if (i <= array.length - s.length() && match(array, i, s)) {
				for (int j = 0; j < t.length(); j++) {
					array[left++] = t.charAt(j);
				}
				i += s.length() - 1;
			} else {
				array[left++] = array[i];
			}
		}
		return new String(array, 0, left);
	}
	private String replaceLarge(char[] array, String s, String t) {
		List<Integer> matches = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (i <= array.length - s.length() && match(array, i, s)) {
				i += s.length() - 1;
				matches.add(i);
			}
		}
		char[] res = new char[array.length + (t.length() - s.length()) * matches.size()];
		int index = res.length - 1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (!matches.contains(i)) {
				res[index--] = array[i];
			} else {
				for (int j = t.length() - 1; j >= 0; j--) {
					res[index--] = t.charAt(j);
				}
				matches.remove(matches.size() - 1);
				i = i - s.length() + 1;
			}
		}
		return new String(res);
	}
	private boolean match(char[] array, int index, String s) {
		for (int start = 0; start < s.length(); start++) {
			if (array[index + start] != s.charAt(start)) {
				return false;
			}
		}
		return true;
	}
}