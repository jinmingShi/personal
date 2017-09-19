public class Solution {
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return null;
		}
		int index = 0; 
		int left = 0;
		int right = array.length - 1;
		while (index <= right) {
			if (array[index] == 1) {
				swap(array, index, right--);
			} else if (array[index] == -1) {
				swap(array, index++, left++);
			} else {
				index++;
			}
		}
		return array;
	}
	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}