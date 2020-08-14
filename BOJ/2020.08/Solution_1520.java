import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1520 {
	static int[][] map;
	static int[][] dp; 
	static int n, m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = -1;
			}
		}
	
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int x, int y) {
		if (x == n - 1 && y == m - 1) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < n && ny < m){
				if (map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}