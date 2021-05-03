import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11404 {
	static int[][] dist;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		dist = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = 987654321;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			dist[x][y] = Math.min(dist[x][y], w);
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == 987654321) {
					sb.append(0 + " ");
				}
				else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}