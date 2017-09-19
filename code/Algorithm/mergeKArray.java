public class Solution() {
	public int[] merge(int[][] array) {
		if (array.length == 0) {
			return new int[0];
		}
		PriorityQueue<Cell> heap = new PriorityQueue<>(array.length, new Comparator<Cell>() {
			public int compare(Cell c1, Cell c2) {
				if (c1.val == c2.val) {
					return 0;
				}
				return c1.val < c2.val ? -1 : 1;
			}
		});
		int len = 0;
		for (int i = 0; i < array.length; i++) {
			int[] temp = array[i];
			if (temp.length != 0) {
				len += temp.length;
				heap.offer(new Cell(i, 0, array[i][0]));
			}
		}
		int[] res = new int[len];
		int index = 0;
		while (!heap.isEmpty()) {
			Cell cur = heap.poll();
			res[index++] = cur.val;
			int row = cur.x;
			int col = cur.y;
			if (col + 1 < array[row].length) {
				heap.offer(new Cell(row, col + 1, array[row][col + 1]));
			}
		}
		return res;
	}

}
class Cell {
	int x;
	int y;
	int val;
	public Cell(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}