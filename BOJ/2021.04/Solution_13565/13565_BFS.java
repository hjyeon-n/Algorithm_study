import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < M; i++) {
			if (map[0][i] == 0) {
				map[0][i] = 2;
				bfs(0, i);
			}
		}
		
		for (int i = 0; i < M; i++) {
			if (map[N - 1][i] == 2) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	
	public static void bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<Location>();
		visited[x][y] = true;
		queue.offer(new Location(x, y));
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int a = loc.x;
			int b = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] != 1) {
						map[nx][ny] = 2;
						visited[nx][ny] = true;
						queue.offer(new Location(nx, ny));
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