public class Solution {
	public int ifSubstr(String large, String small) {
		if (small.length() == 0) {
			return 0;
		} else if (large.length() < small.length()) {
			return -1;
		}
		for (int i = 0; i <= large.length() - small.length(); i++) {
			int j;
			for (j = 0; j < small.length(); j++) {
				if (large.charAt(i + j) != small.charAt(j)) {
					break;
				}
			}
			if (j == small.length()) {
				return i;
			}
		}
		return -1;
	}
}