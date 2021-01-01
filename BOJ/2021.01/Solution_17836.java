import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17836 {
	static int N, M, T;
	static int[][][] visited;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[N][M][2];
		BFS();
	}
	
	public static void BFS() {
		Queue<Location> queue = new LinkedList<Location>();
		visited[0][0][0] = 1;
		queue.offer(new Location(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			int wall = loc.wall;
			int time = loc.time;
			
			if (time > T) {
				continue;
			}
			
			if (map[x][y] == 2) {
				wall = 1;
				visited[x][y][wall] = time;
			}
			
			if (x == N - 1 && y == M - 1) {
				System.out.println(time);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (wall == 1) {
						if (visited[nx][ny][1] == 0) {
							visited[nx][ny][1] = time + 1;
							queue.offer(new Location(nx, ny, wall, time + 1));
						}
					}
					else {
						if (visited[nx][ny][0] == 0 && map[nx][ny] != 1) {
							visited[nx][ny][0] = time + 1;
							queue.offer(new Location(nx, ny, wall, time + 1));
						}
					}
				}
			}
		}
		System.out.println("Fail");
	}
}

class Location {
	int x;
	int y;
	int wall;
	int time;
	
	public Location(int x, int y, int wall, int time) {
		this.x = x;
		this.y = y;
		this.wall = wall;
		this.time = time;
	}
}