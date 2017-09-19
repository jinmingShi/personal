
// review the comment in specific lines 

public class Solution {
	public int[] mergeSort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}	
		int[] helper = new int[array.length];
		sort(array, 0, array.length - 1, helper);
		return array;
	}
	private void sort(int[] array, int left, int right, int[] helper) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		sort(array, left, mid, helper);
		sort(array, mid + 1, right, helper);
		merge(array, left, mid, right, helper);
	}
	public void merge(int[] array, int left, int mid, int right, int[] helper) {
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}
		int lo = left;
		int hi = mid + 1;
		while (lo <= mid && hi <= right) {
			if (helper[lo] < helper[hi]) {
				array[left++] = helper[lo++];
			} else {
				array[left++] = helper[hi++];
			}
		}
		while(lo <= mid) {
			array[left++] = helper[lo++];
		} 
		/* if there are some elements at right side, 
		   we don't neew to copy the right part, 
		   because thry are already sorted and in the right place.
		*/
	}
}