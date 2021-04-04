import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 3187_DFS {
	static int tmp_sheep, tmp_wolf;
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		int sheep = 0;
		int wolf = 0;
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					tmp_sheep = 0;
					tmp_wolf = 0;

					dfs(i, j);
					
					if (tmp_wolf < tmp_sheep) {
						sheep += tmp_sheep;
					}
					else {
						wolf += tmp_wolf;
					}
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
	
	public static void dfs(int a, int b) {
		visited[a][b] = true;
		
		if (map[a][b] == 'k') {
			tmp_sheep++;
		}
		
		if (map[a][b] == 'v') {
			tmp_wolf++;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (!visited[nx][ny] && map[nx][ny] != '#') {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}
}