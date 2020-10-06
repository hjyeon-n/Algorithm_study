import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 2573_BFS_ver2 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited; 
	static int[][] melt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int time = 0;
		while (true) {
			melt = new int[N][M];
			visited = new boolean[N][M];
			
			int cnt = 0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						countIce(i, j);
						cnt++;
					}
				}
			}
			
			if (cnt == 0) {
				System.out.println("0");
				return;
			}
			
			if (cnt >= 2) {
				System.out.println(time);
				return;
			}
			
			meltIce();
			time++;
		}
	}
	
	public static void meltIce() {
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < M - 1; j++) {
				map[i][j] -= melt[i][j];
				
				if (map[i][j] < 0) {
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void countIce(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y));
		visited[bfs_x][bfs_y] = true;
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x >= N && y >= M) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0) {
						melt[x][y]++;
					}
					
					if (map[nx][ny] != 0 && !visited[nx][ny]) {
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
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