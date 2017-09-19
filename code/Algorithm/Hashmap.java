
public class HashMap {
	public static class Entry<String, Integer> {
		private String key;
		private Integer val;
		private Entry<String, Integer> next;
		private Entry(String key, Integer val) {
			this.key = key;
			this.val = val;
			this.next = null;
		}
	}

	private int final default_size = 20;
	private Entry<String, Integer>[] array = null;
	
	public HashMap(int size) {
		this.array = (Entry<String, Integer>[])(new Entry[size]);
	}

	public HashMap() {
		this(default_size);
	}

	private int hash(String key) {
		if (key == null) {
			return 0;
		}
		return key.hashCode() & OX7FFFFFFF;
	}

	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}

	public Integer remove(String key) {
		Entry<String, Integer> cur = array[hash(key)];
		Entry<String, Integer> pre = cur;
		while (cur != null && !key.equals(cur.val)) {
			pre = cur;
			cur = cur.next;
		}
		if (cur == null) {
			return null;
		}
		Integer n;
		if (cur != pre) {
			n = cur.val;
			pre.next = cur.next;
		} else {
			n = cur.val;
			array[index] = cur.next;
		}
		return n;
	}	

	public boolean containsKey(String key) {
		Entry<String, Integer> cur = array[hash(key)];
		while (cur != null) {
			if (key.equals(cur.key)) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	public Integer put(String key, Integer val) {
		Entry<String, Integer> cur = array[hash(key)];
		while (cur != null) {
			if (key.equals(cur.key)) {
				Integer n = cur.val;
				cur.val = val;
				return n;
			}
			cur = cur.next;
		}
		cur = array[index].next;
		array[index] = new Entry(key, val);
		array[index].next = cur;
		return null; 
	}

	public Integer get(String key) {
		Entry<String, Integer> cur = array[hash(key)];
		while (cur != null) {
			if (key.equals(cur.key)) {
				return cur.val;
			}
			cur = cur.next;
		}
		return null;
	}
}