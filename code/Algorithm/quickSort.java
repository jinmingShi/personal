public class Solution {
	public void quickSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		partition(array, 0, array.length - 1);
		return array;
	}
	private void partition(int[] array, int left, int right) {
		if (left >= right) {
			return;
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
				swap(array, leftIndex++, rightIndex--);
			}
		}
		swap(array, leftIndex, right);
		partition(array, left, leftIndex - 1);
		partition(array, leftIndex + 1, right);
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}