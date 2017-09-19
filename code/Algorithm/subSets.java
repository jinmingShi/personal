public class Solution() {
	public List<String> seuSets(String input) {
		List<String> res = new ArrayList<>();
		if (input == null) {
			return res;
		}	
		StringBuilder sb = new StringBuilder();
		DFS(input, sb, 0, res);
		return res;
	}
	private void DFS(String input, StringBuilder sb, int level, List<String> res) {
		if (level == input.length()) {
			res.add(sb.toString());
			return;
		}
		sb.append(input.charAt(level));
		DFS(input, sb, level + 1, res);
		sb.deleteCharAt(sb.length() - 1);
		DFS(input, sb, level + 1, res);
	}
}