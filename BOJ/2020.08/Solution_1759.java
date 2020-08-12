import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Solution_1759 {
	static boolean[] visited;
	static char[] lotto;
	static char[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[m];
		arr = new char[m];
		lotto = new char[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);

		dfs(n, m, 0, 0);
	}
	
	private static void dfs(int n, int m, int depth, int idx) {
		if (depth == n) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (lotto[i] == 'a' || lotto[i] == 'e' || lotto[i] == 'i' || lotto[i] == 'o' || lotto[i] == 'u') {
					cnt++;
				}
			}
			if (cnt >= 1 && n - cnt >= 2) {
				for (int i = 0; i < n; i++) {
					System.out.print(lotto[i]);
				}
				System.out.println();
			}
			return;
		}
	 
		for (int i = idx; i < m; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lotto[depth] = arr[i];	
				dfs(n, m, depth + 1, i);
				visited[i] = false;
			}
		}
	}
}