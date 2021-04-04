import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 3187_BFS {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int sheep, wolf;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep = 0;
		wolf = 0;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
	
	public static void bfs(int a, int b) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(a, b));
		visited[a][b] = true;
		
		int tmp_wolf = 0;
		int tmp_sheep = 0;
		
		if (map[a][b] == 'v') {
			tmp_wolf++;
		}
		
		if (map[a][b] == 'k') {
			tmp_sheep++;
		}
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if (!visited[nx][ny] && map[nx][ny] != '#') {
						if (map[nx][ny] == 'v') {
							tmp_wolf++;
						}
						
						if (map[nx][ny] == 'k') {
							tmp_sheep++;
						}
						
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		if (tmp_wolf < tmp_sheep) {
			sheep += tmp_sheep;
		}
		else {
			wolf += tmp_wolf;
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