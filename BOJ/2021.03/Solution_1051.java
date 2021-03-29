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
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; k < N; k++) {
					if (i + k < N && j + k < M) {
						if (map[i][j] == map[i + k][j] && map[i][j] == map[i][j + k]
								&& map[i][j] == map[i + k][j + k]) {
							max = Math.max(max, (k + 1) * (k + 1));
						}
					}
				}
 			}
		}
		
		System.out.println(max);
	}
}