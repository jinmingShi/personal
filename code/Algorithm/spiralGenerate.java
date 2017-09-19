public class Solution {
	public int[][] generate(int m, int n) {
		int[][] matrix = new int[m][n];
		int sum = m * n;
		int left = 0;
		int up = 0;
		int right = n - 1;
		int bottom = m - 1;
		while (left < right && up < bottom) {
			for (int i = left; i < right; i++) {
				matrix[up][i] = sum--;
			}
			for (int i = up; i < bottom; i++) {
				matrix[i][right] = sum--;
			}
			for (int i = right; i > left; i--) {
				matrix[i][bottom] = sum--;
			}
			for (int i = bottom; i > up; i--) {
				matrix[i][left] = sum--;
			}
			left++;
			up++;
			right--;
			bottom--;
		}
		if (left > right || up > bottom) {
			return matrix;
		}
		if (left == right) {
			for (int i = up; i <= bottom; i++) {
				matrix[i][left] = sum--;
			}
		} else {
			for (int i = left; i <= right; i++) {
				matrix[left][bottom] = sum--;
			}
		}
		return matrix;
	}
}