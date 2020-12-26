import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 1926_BFS {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int paper = bfs(i, j);
					cnt++;
					max = Math.max(max, paper);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	public static int bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<Location>();
		visited[x][y] = true;
		queue.add(new Location(x, y));
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int loc_x = loc.x;
			int loc_y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = loc_x + dx[i];
				int ny = loc_y + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] != 0 && !visited[nx][ny]) {
						cnt++;
						visited[nx][ny] = true;
						queue.add(new Location(nx, ny));
					}
				}
			}
		}
		return cnt;
	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}