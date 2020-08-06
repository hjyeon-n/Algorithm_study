import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int max;
	static int[][] map;
	static int[][] copy;
	static boolean[][] visited;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		copy = new int[n][m];
		visited = new boolean[n][m];
		max = -1;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}		
		comb(0, 0);
		System.out.println(max);
	}

	static void comb(int start, int depth) {
		if (depth == 3) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					copy[i][j] = map[i][j];
					visited[i][j] = false;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (copy[i][j] == 2 && !visited[i][j]) {
						dfs(i, j);
					}
				}
			}
						
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (copy[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			max = Math.max(max, cnt);
			return;
		}

		for (int i = start; i < n * m; i++) {
			int x = i / m;
			int y = i % m;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				comb(i + 1, depth + 1);
				map[x][y] = 0;
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		copy[x][y] = 2;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < n && ny < m){
				if(map[nx][ny] == 0 && !visited[nx][ny]){
					dfs(nx,ny);
				}
			}
		}
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}