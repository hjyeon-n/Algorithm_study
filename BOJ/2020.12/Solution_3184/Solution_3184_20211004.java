import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int rslt_w, rslt_s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		rslt_w = 0;
		rslt_s = 0;
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(rslt_s + " " + rslt_w);
	}
	
	public static void bfs(int a, int b) {		
		Queue<Location> queue = new LinkedList<Location>();
		visited[a][b] = true;
		queue.add(new Location(a, b));
		
		int sheep = 0;
		int wolf = 0;
		
		if (map[a][b] == 'o') {
			sheep++;
		}
		
		if (map[a][b] == 'v') {
			wolf++;
		}
	
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && map[nx][ny] != '#') {
						visited[nx][ny] = true;
						queue.add(new Location(nx, ny));
						
						if (map[nx][ny] == 'o') {
							sheep++;
						}
						
						if (map[nx][ny] == 'v') {
							wolf++;
						}
					}
				}
			}
		}
		
		if (wolf < sheep) {
			rslt_s += sheep;
		}
		else {
			rslt_w += wolf;
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