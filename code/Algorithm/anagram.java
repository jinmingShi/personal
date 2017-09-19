public class Solution {
	public List<Integer> anagram(String s, String l) {
		List<Integer> res = new ArrayList<>();
		if (s.length() < l.length() || l.length() == 0) {
			return res;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < l.length(); i++) {
			Integer n = map.get(l.charAt(i));
			if (n == null) {
				map.put(l.charAt(i), 1);
			} else {
				map.put(l.charAt(i), n + 1);
			}
		}
		char[] array = s.toCharArray();
		int size = map.size();
		int slow = 0;
		int fast = 0;
		int len = l.length();
		while (fast < array.length) {
			if (fast - slow + 1 <= len) {
				Integer n = map.get(array[fast]);
				if (n != null) {
					map.put(array[fast], --n);
					if (n == 0) {
						size--;
					}
				}
				fast++;
			} else {
				Integer c = map.get(array[slow]);
				if (c != null) {
					map.put(array[slow], ++c);
					if (c == 1) {
						size++;
					}
				}
				slow++;
			}
			if (size == 0) {
				res.add(slow);
			}
		}
	}
}