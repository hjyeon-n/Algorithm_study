import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_2206 {
	static int[][] map;
	static boolean[][][] visited; 
	static int n, m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m][2];

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
	}

	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		queue.add(new Location(0, 0, 0, 1));
		Location loc;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			int crush = loc.crush;
			int depth = loc.depth;

			if (x == n - 1  && y == m - 1) {
				System.out.println(depth);
				return;
			}

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m){
					if (map[nx][ny] == 0 && !visited[nx][ny][crush]){
						queue.add(new Location(nx, ny, crush, depth + 1));
						visited[nx][ny][crush] = true;
					}
					if (map[nx][ny] == 1 && !visited[nx][ny][1] && crush == 0) {
						queue.add(new Location(nx, ny, 1, depth + 1));
						visited[nx][ny][1] = true;
					}
				}
			}
		}
		System.out.println("-1");
	}
}
class Location {
	int x, y, crush, depth;
	public Location(int x, int y, int crush, int depth) {
		this.x = x;
		this.y = y;
		this.crush = crush;
		this.depth = depth;
	}
}