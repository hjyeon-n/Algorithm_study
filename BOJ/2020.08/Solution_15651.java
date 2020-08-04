import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		arr = new int[n];
		
		dfs(n, m, 0);
		System.out.print(sb);
	}
	
	private static void dfs(int n, int m, int depth) throws IOException {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
	 
		for (int i = 0; i < n; i++) {
			arr[depth] = i + 1;	
			dfs(n, m, depth + 1);	
		}
	}
}