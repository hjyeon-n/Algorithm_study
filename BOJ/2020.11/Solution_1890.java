import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1890 {
	static int[][] map;
	static long[][] memo;
	static int N;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		memo = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}
		long cnt = sol(0, 0);
		System.out.println(cnt);
	}
	
	public static long sol(int x, int y) {
		if (x == N - 1 && y == N -1) {
			return 1;
		}
		
		if (memo[x][y] != - 1) {
			return memo[x][y];
		}

		memo[x][y] = 0;
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i] * map[x][y];
			int ny = y + dy[i] * map[x][y];

			if (nx < N && ny < N) {
				memo[x][y] += sol(nx, ny);
			}
		}

		return memo[x][y];
	}
}