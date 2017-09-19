public class Solution {
	public int longestSub(String input) {
		if (input.length <= 1) {
			return input.length();
		}
		int slow = 0;
		int fast = 0;
		Set<Character> set = new HashSet<>();
		int global = Integer.MIN_VALUE;
		while (fast < input.length()) {
			if (!set.contains(input.charAt(fast))) {
				set.add(input.charAt(fast));
				global = Math.max(global, fast - slow + 1);
				fast++;
			} else {
				set.remove(input.charAt(slow));
				slow++;
			}
		}
		return global;
	}
}