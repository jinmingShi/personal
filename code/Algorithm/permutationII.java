public class Solution {
	public List<String> permutationII(String input) {
		List<String> res = new ArrayList<>();
		if (input == null) {
			return res;
		}
		char[] array = input.toCharArray();
		permutationII(array, 0, res);
		return res;
	}
	private void permutationII(char[] array, int level, List<String> res) {
		if (level == array.length) {
			res.add(new String(array));
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = level; i < array.length; i++) {
			if (set.add(array[i])) {
				swap(array, level, i);
				permutationII(array, level + 1, res);
				swap(array, level, i);
			}
		}
	}
	private void swap(char[] array, int i, int j) {
		char ch = array[i];
		array[i] = array[j];
		array[j] = ch;
	}

}