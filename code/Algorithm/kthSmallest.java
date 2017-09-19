public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.val == c2.val) {
					return 0;
				}
				return c1.val > c2.val ? 1 : -1;
			}
		});
		int row = matrix.length;
		int col = matrix[0].length;
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		boolean[][] flag = new boolean[row][col];
		flag[0][0] = true;
		int i = 0;
		while (!minHeap.isEmpty() && i < k - 1) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < row && !flag[cur.row + 1][cur.col]) {
				minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				flag[cur.row + 1][cur.col] = true;
			}
			if (cur.col + 1 < col && !flag[cur.row][cur.col + 1]) {
				minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				flag[cur.row][cur.col + 1] = true;
			}
			i++;
		}
		return res = minHeap.poll().val;
	}
}
class Cell {
	int row;
	int col;
	int val;
	public Cell(int row, int col, int val) {
		this.row = row;
		this.col = col;
		this.val = val;
	}
}