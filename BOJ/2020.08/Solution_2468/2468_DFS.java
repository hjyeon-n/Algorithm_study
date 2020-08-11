import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 2468_DFS {
	static int n;
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
		
		map = new int[n][n];
		copy = new int[n][n];
		visited = new boolean[n][n];
		max = 0;
		
		int max_h = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				max_h = Math.max(map[i][j], max_h);
			}
		}		
		
		for (int h = 0; h < max_h; h++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = false;
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] > h) {
						copy[i][j] = 1;
					}
					else {
						copy[i][j] = -1;
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (copy[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			max = Math.max(cnt, max);	
		}
		System.out.println(max);
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < n && ny < n){
				if(copy[nx][ny] == 1 && !visited[nx][ny]){
					dfs(nx, ny);
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