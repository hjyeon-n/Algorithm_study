import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 10451_ver2 {
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			visited = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					dfs(j);
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int node) {
		if (visited[node]) {
			return;
		}
		visited[node] = true;
		dfs(arr[node]);
	}
}