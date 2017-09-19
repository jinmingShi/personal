public class selection {
	public void selectionSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.lenth; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}
}

public class solution {
	public int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}

		}
		if (array[start] == target) {
			return start;
		} else {
			return end;
		}
	}
}