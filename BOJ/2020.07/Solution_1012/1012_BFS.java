import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 1012_BFS {
	static int[][] map;
	static boolean[][] visited; 
	static int n;
	static int m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int loopNum = Integer.parseInt(br.readLine());
		
		for (int loop = 0; loop < loopNum; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int cabNum = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visited = new boolean[n][m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visited[i][j] = false;
				}
			}
			
			for (int cab = 0; cab < cabNum; cab++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				int y = Integer.parseInt(str.nextToken());
				int x = Integer.parseInt(str.nextToken());
				
				map[x][y] = 1;
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 1 && visited[i][j] == false) {
						list.add(bfs(i, j));
					}
				}
			}
			Collections.sort(list);
			System.out.println(list.size());
		}		
	}

	public static int bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = true;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		int cnt = 1;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x >= n  && y >= m) {
				break;
			}

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < n && ny < m){
					if(map[nx][ny] == 1 && !visited[nx][ny]){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}	
		return cnt;
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}