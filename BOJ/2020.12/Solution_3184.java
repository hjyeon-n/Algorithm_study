import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3184 {
	static char[][] map;
	static boolean[][] visited;
	static int R, C;
	static int sheep, wolf;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		sheep = 0;
		wolf = 0;
		
		map = new char[R][C];
		visited = new boolean[R][C];

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

	public static void bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<Location>();
		visited[x][y] = true;
		queue.add(new Location(x, y));

		int s = 0;
		int w = 0;
		
		if (map[x][y] == 'v') {
			w++;
		}
		else if (map[x][y] == 'o') {
			s++;
		}
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int loc_x = loc.x;
			int loc_y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = loc_x + dx[i];
				int ny = loc_y + dy[i];
				
				if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if (map[nx][ny] != '#' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Location(nx, ny));
						
						if (map[nx][ny] == 'v') {
							w++;
						}
						else if (map[nx][ny] == 'o') {
							s++;
						}
					}
				}
			}
		}
		
		if (w >= s) {
			wolf += w;
		}
		else {
			sheep += s;
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