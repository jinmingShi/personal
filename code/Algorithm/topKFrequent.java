public class Solution {
	public String[] topK(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (String s : combo) {
			Intger n = map.get(s);
			if (n == null) {
				map.put(s, 1);
			} else {
				map.put(s, n + 1);
			}
		}
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, 
			new Comparator<Map.Entry<String, Integer>>() {
				public void compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
					return e1.getValue().compareTo(e2.getValue());
				}
		});
		/*  Use iterator to iterate the minHeap
		Iterator<Map.Entry<String, Integer>> ite = map.entrySet().iterator();
		while (ite.hasNext()) {
			Map.Entry<String, Integer> e  = ite.next();
			if (minHeap.size() < k) {
				minHeap.offer(e);
			} else if (minHeap.peek().getValue() < e.getValue()) {
				minHeap.poll();
				minHeap.offer(e);
			}
		}
		*/
		int count = 0;
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (count < k) {
				minHeap.offer(e);
			} else if (e.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(e);
			}
		}
		String[] res = new String[minHeap.size()];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}

}