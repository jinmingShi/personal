public class Solution {
	public String deCompress(String input) {
		if (input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		List<Integer> pos = new ArrayList<>();
		int slow = 0;
		for (int i = 1; i < array.length; i += 2) {
			int c = getInt(array[i]);
			if (c >= 0 && c <= 2) {
				for (int j = 0; j < c; j++) {
					array[slow++] = array[i - 1];
				}
			} else {
				array[slow++] = array[i - 1];
				pos.add(slow);
				array[slow++] = array[i];
			}
		}
		int total = 0;
		for (int i : pos) {
			total += getInt(array[i]) - 2;
		}
		char[] res = new char[slow + total];
		slow--;
		int index = res.length - 1;
		while (slow >= 0) {
			if (pos.contains(slow)) {
				int count = getInt(array[slow]);
				char ch = array[slow - 1];
				for (int i = 0; i < count; i++) {
					res[index--] = ch;
				}
				pos.remove(pos.size() - 1);
			} else {
				res[index--] = array[slow];
			}
			slow--;
		}
		return new String(res);
	}
	private int getInt(char c) {
		return c - '0';
	}
}