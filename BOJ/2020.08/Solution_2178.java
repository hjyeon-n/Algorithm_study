import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[][] map;
	static int[][] visited; 
	static int n;
	private static int dx[] = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int dy[] = {-1, 1, -1, 1, -2, 2, -2, 2};
    static int now_x, now_y;
    static int end_x, end_y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < loop; i++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new int[n][n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			now_x = Integer.parseInt(st.nextToken());
			now_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			bfs(now_x, now_y);
			System.out.println(visited[end_x][end_y] - 1);
		}
	}

	public static void bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = 1;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x >= n  && y >= n) {
				break;
			}
			
			if (x == end_x && y == end_y) {
				return;
			}

			for(int i = 0; i < 8; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < n){
					if(visited[nx][ny] == 0){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = visited[x][y] + 1;
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