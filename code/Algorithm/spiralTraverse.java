public class Solution() {
	public List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0) {
			return res;
		}
		spiral(matrix, 0, matrix.length, res);
		return res;
	}
	private void spiral(int[][] matrix, int offset, int size, List<Integer> res) {
		if (size == 0) {
			return;
		}
		if (size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			res.add(martix[i + offset][size - 1 + offset]);
		}
		for (int i = size - 1; i > 0; i--) {
			res.add(martix[size + offset - 1][i + offset]);
		}
		for (int i = size - 1 + offset; i > 0; i--) {
			res.add(martix[i][offset]);
		}
		spiral(matrix, offst + 1, size - 2, res);
	}
}