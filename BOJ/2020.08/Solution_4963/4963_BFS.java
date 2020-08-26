import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 4963_BFS {
	static int[][] map;
	static boolean[][] visited; 
	static int w, h;
	static int cnt;
	private static int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
    private static int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) {
				break;
			}
			map = new int[h + 1][w + 1];
			visited = new boolean[h + 1][w + 1];
			
			for(int i = 1; i <= h; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
				}
			}
			
			cnt = 0;
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = true;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		cnt = cnt + 1;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x > h  && y > w) {
				break;
			}

			for(int i = 0; i < 8; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 1 && ny >= 1 && nx <= h && ny <= w){
					if(map[nx][ny] == 1 && !visited[nx][ny]){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}	
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}