public class Solution {
	/* Two ways to solve this problem.
	   1. Quick partition to find the index of k.
	   2. MaxHeap
	*/

	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		helper(array, 0, array.length - 1, k - 1);
		int[] res = Arrays.copyOf(array, k);
		Arrays.sort(res);
		return res;
	}
	public int helper(int[] array, int left, int right, int k) {
		int index = partition(array, left, right);
		if (index == k) {
			return k;
		} else if (index < k) {
			return helper(array, index + 1, right, k);
		} else {
			return  helper(array, left, index - 1, k);
		}
	}
	public int partition(int[] array, int left, int right) {
		if (left >= right) {
			return left;
		}
		int pivot = array[right];
		int leftIndex = left;
		int rightIndex = right - 1;
		while (leftIndex <= rightIndex) {
			while (leftIndex <= rightIndex && array[leftIndex] < pivot) {
				leftIndex++;
			}
			while (leftIndex <= rightIndex && array[rightIndex] >= pivot) {
				rightIndex--;
			}
			if (leftIndex <= rightIndex) {
				int temp = array[leftIndex];
				array[leftIndex] = array[rightIndex];
				array[rightIndex] = temp;
				leftIndex++;
				rightIndex--;
			}
		}
		int temp = array[leftIndex];
		array[leftIndex] = array[right];
		array[right] = temp;
		return leftIndex;
	}
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			public int compare(Integer e1, Integer e2) {
				if (e1.equals(e2)) {
					return 0;
				}
				return e1 > e2 ? -1 : 1;
			}
		})
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				maxHeap.offer(array[i]);
			} else {
				if (array[i] < maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.offer(array[i]);
				}
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; k--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
}