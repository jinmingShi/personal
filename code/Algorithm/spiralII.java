public class Solution {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}
		int[] d = new int[]{matrix.length, matrix[0].length;}
		int up = 0;
		int left = 0;
		int bottom = array.length - 1;
		int right = array[0].length - 1;
		spiral(matrix, left, up, right, bottom, res);
		if (up == bottom) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[up][i]);
			}
		} else if (left == right) {
			for (int i = up; i <= bottom; i++) {
				res.add(matrix[i][left]);
			}
		}
		return res;
	}
	public void spiral(int[][] matrix, int left, int up, int right, int bottom, List<Integer> res) {
		if (left >= right || up >= bottom) {
			return;
		}
		for (int i = left; i < right; i++) {
			res.add(matrix[up][i]);
		}
		for (int i = up; i < bottom - 1; i++) {
			res.add(matrix[i][right]);
		}
		for (int i = right; i > left; i--) {
			res.add(matrix[bottom][i]);
		}
		for (int i = bottom; i > up; i--) {
			res.add(matrix[i][left]);
		}
		left++;
		up++;
		bottom--;
		right--;
		spiral(matrix, left, up, right, bottom, res);
	}
}