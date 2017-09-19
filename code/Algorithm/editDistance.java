public class Solution {
	
	// recursion way : 3 - branched tree, Time: O(3^2n)
	public int editDistance(String one, String two) {
		if (one.length() == 0) {
			return two.length();
		}
		if (two.length() == 0) {
			return one.length();
		}
		int nothing = Integer.MAX_VALUE;
		if (one.charAt(0) == two.charAt(0)) {
			nothing = editDistance(one.substring(1), two.substring(1));
		}
		int replace = 1 + editDistance(one.substring(1), two.substring(1));
		int delete = 1 + editDistance(one.substring(1), two);
		int insert = 1 + editDistance(one, two.substring(1));
		return Math.min(replace, Math.min(delete, Math.min(insert, nothing)));
	}

	public int editDistanceI(String one, String two) {
		if (one.length() == 0) {
			return two.length();
		}
		if (two.length() == 0) {
			return one.length();
		}
		int[][] matrix = new int[one.length() + 1][two.length() + 1];
		matrix[0][0] = 0;
		for (int i = 1; i <= one.length(); i++) {
			matrix[i][0] = i;
			for (int j = 1; j <= two.length(); j++) {
				matrix[0][j] = j;
				if (one.charAt(i - 1) == one.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 1 + Math.min(matrix[i][j - 1], 
						Math.min(matrix[i - 1][j], Matrix[i - 1][j - 1]));
				}
			}
		}
		return matrix[one.length()][two.length()];
	}
}