public class Solution {
	public String encoding(String input) {
		if (input == null || input.length <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		List<Integer> short = new ArrayList<>();
		while (fast < array.length) {
			int i;
			for (i = 1; i < array.length - fast; i++) {
				if (array[fast] != array[fast + i]) {
					break;
				}
			}
			if (i >= 2) {
				array[slow++] = array[fast];
				array[slow++] = i;
				fast += i;
			} else {
				short.add(slow);
				array[slow++] = array[fast++];
			}
		}
		char[] res = new char[slow + short.size()];
		int index = res.length - 1;
		slow--;
		while (slow >= 0) {
			if (short.contains(slow)) {
				res[index--] = '1';
				res[index--] = array[slow]; 
			} else {
				res[index--] = array[slow];
			}
			slow--;
		}
		return new String(res);
	}
}