import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_15650 {
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		
		dfs(n, m, 0, 0);
	}
	
	private static void dfs(int n, int m, int depth, int idx) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
	 
		for (int i = idx; i < n; i++) {
			arr[depth] = i + 1;	
			dfs(n, m, depth + 1, i + 1);
		}
	}
}