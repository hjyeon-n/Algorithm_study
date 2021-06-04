import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16948 {
	static int[][] map;
	static boolean[][] visited;
	static int N, answer;
	static int r1, r2, c1, c2;
	static int[] dx = {-2, 2, 0};
	static int[] dy = {-1, 1, -1, 1, -2, 2};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		answer = -1;
		bfs(r1, c1);
		
		System.out.println(answer);
	}

	public static void bfs (int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y, 0));
		visited[bfs_x][bfs_y] = true;
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			int cnt = loc.cnt;
			
			if (x == r2 && y == c2) {
				answer = cnt;
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = i * 2; j < i * 2 + 2; j++) {
					int nx = x + dx[i];
					int ny = y + dy[j];
					
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (!visited[nx][ny]) {
							visited[nx][ny] = true;
							queue.add(new Location(nx, ny, cnt + 1));
						}
					}
				}
			}
		}
	}
}

class Location {
	int x, y, cnt;
	
	public Location(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
