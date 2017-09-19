public class Solution() {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<Integer>();
		if (a.length == 0 || b.length == 0) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) {
			Integer n = map.get(i);
			if (n == null) {
				map.put(i, 1);
			} else {
				map.put(i, n + 1);
			}
		}
		for (int n : b) {
			int count = map.get(b);
			if (count != null && count > 0) {
				res.add(n);
				map.put(n, --count);
			}
		}
		return res;
	}
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		if (a.length == 0 || b.length == 0) {
			return res;
		}
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				res.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return res;
	}
}





