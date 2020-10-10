import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = map[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i - 1 >= 0) {
					visited[i][j] = Math.max(visited[i][j], map[i][j] + visited[i - 1][j]);
				}
				if (j - 1 >= 0) {
					visited[i][j] = Math.max(visited[i][j], map[i][j] + visited[i][j - 1]);
				}
				if (i - 1 >= 0 && j - 1 >= 0) {
					visited[i][j] = Math.max(visited[i][j], map[i][j] + visited[i - 1][j - 1]);
				}
			}
		}
		
		System.out.println(visited[N - 1][M - 1]);
	}
}