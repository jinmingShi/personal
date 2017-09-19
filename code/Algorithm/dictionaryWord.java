public class Solution {
	public boolean canBreak(String input, String[] dict) {
		HashSet<String> set = new HashSet<>();
		for (String s : dict) {
			set.add(s);
		}
		boolean[] res = new boolean[input.length() + 1];
		M[0] = true;
		for (int i = 1; i <= input.length(); i++) {
			if (set.contains(input.subString(0, i))) {
				M[i] = true;
			} else {
				for (int j = 1; j <= i; j++) {
					if (M[j] && input.subString(j, i)) {
						M[i] = true;
						break;
					}
				}
			}
		}
		return M[input.length()];
	}
}