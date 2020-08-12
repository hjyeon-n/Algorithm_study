import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_6603 {
	static boolean[] visited;
	static int[] lotto;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				return;
			}
			StringTokenizer st = new StringTokenizer(str);
			
			int n = Integer.parseInt(st.nextToken());
			visited = new boolean[n];
			arr = new int[n];
			lotto = new int[n];
			
			int i = 0; 
			while (st.hasMoreTokens()) {
				arr[i++] = Integer.parseInt(st.nextToken());
			}			
			
			dfs(n, 0, 0);
			System.out.println();
		}
	}
	
	private static void dfs(int n, int depth, int idx) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				lotto[depth] = arr[i];	
				dfs(n, depth + 1, i);
				visited[i] = false;
			}
		}
	}
}