/*
  Two ways to solve:
  1. create StringBuilder
  2. set an fixed length array.
*/
public class Solution {
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		validParentheses(0, 0, n, sb, res);
		return res;
	}
	private void validParentheses(int left, int right, int n, StringBuilder sb, List<String> res) {
		if (left == n && right == n) {
			res.add(sb.toString());
			return;
		}
		if (left < n) {
			sb.append("(");
			validParentheses(left + 1, right, n, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(")");
			validParentheses(left, right + 1, n, sb, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	

	// 2nd way to solve
	public List<String> validParentheses(int n) {
		List<String> res = new ArrayList<>();
		char[] array = new char[n * 2];
		validParentheses(array, 0, 0, n, res);
		return res;
	}
	private void validParentheses(char[] array, int left, int right, int n, List<String> res) {
		if (left == n && right == n) {
			res.add(new String(array));
			return;
		}
		if (left < n) {
			array[left + right] = '(';
			validParentheses(array, left + 1, right, n, res);
		}
		if (right < left) {
			array[left + right] = ')';
			validParentheses(array, left, right + 1, n, res);
		}
	}
}

















