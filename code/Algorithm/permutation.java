public class Solution {
	public List<String> permutation(String input) {
		List<String> res = new ArrayList<>();
		if (input == null) {
			return res;
		}
		char[] array = input.toCharArray();
		permutation(array, 0, res);
		return res;
	}
	private void permutation(char[] array, int level, List<String> res) {
		if (level == array.length) {
			res.add(new String(array));
			return;
		}
		for (int i = level; i < array.length; i++) {
			swap(array, level, i);
			permutation(array, level + 1, res);
			swap(array, level, i);
		}
	}
	private void swap(char[] array, int i, int j) {
		char c = array[i];
		array[i] = array[j];
		array[j] = c;
	}
}