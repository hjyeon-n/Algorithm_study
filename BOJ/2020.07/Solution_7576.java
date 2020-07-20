import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_7576 {
	static int[][] map;
	static int[][] visited; 
	static int n;
	static int m;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    static Queue<Location> queue;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];

		int flag = 1;
		for(int i = 0; i < n; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					flag = 0;
				}
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		if (flag == 1) {
			System.out.println("0");
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = 0;
			}
		}

		queue = new LinkedList<Location>();	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					queue.add(new Location(i, j));
					visited[i][j] = 1;
				}
			}
		}
		bfs();
				
		int max = -1;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0) {
					if (map[i][j] == 0) {
						System.out.println("-1");
						return;
					}
				}
				max = Math.max(max, visited[i][j]);
			}
		}
		System.out.println(max - 1);
	}

	public static void bfs() {
		Location loc;

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
					if(map[nx][ny] == 0 && visited[nx][ny] == 0){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = visited[x][y] + 1;
						map[nx][ny] = 1;
					}
					
					if(map[nx][ny] == -1 && visited[nx][ny] == 0){
						visited[nx][ny] = -1;
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