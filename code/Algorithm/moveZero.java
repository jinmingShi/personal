public class Solution {
	public int[] moveZero(int[] array) {
		if (array.length == 0) {
			return array;
		}
		int left = 0;
		int right = 0;
		while (right < array.length) {
			if (array[right] != 0) {
				array[left++] = array[right];
			} 
			right++;
		}
		while (left < array.length) {
			array[left++] = 0;
		}
		return array;
	}
}