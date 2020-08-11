import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static char[][] map;
	static int[][] visited; 
	static int n;
	static int m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new int[n][m];

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int max = -1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'L' && visited[i][j] == 0) {
					bfs(i, j);
					max = Math.max(max, findMax());
				}
			}
		}
		System.out.println(max - 1);
	}

	public static void bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = 1;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x >= n  && y >= m) {
				break;
			}

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m){
					if(map[nx][ny] == 'L' && visited[nx][ny] == 0){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = visited[x][y] + 1;
					}
				}
			}
		}	
	}
	
	public static int findMax() {
		int max = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < visited[i][j]) {
					max = visited[i][j];
				}
				visited[i][j] = 0;
			}
		}
		return max;
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}