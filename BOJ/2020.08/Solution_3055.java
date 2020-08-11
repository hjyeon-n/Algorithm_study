import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_3055 {
	static char[][] map;
	static int[][] visited; 
	static int n;
	static int m;
	static int start_x, start_y;
	static int end_x, end_y;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    static Queue<Location> queue;
    static Queue<Location> water_queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visited = new int[n][m];
		
		queue = new LinkedList<Location>();
		water_queue = new LinkedList<Location>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'S') {
					queue.add(new Location(i, j));
				}
				
				if (map[i][j] == '*') {
					water_queue.add(new Location(i, j));
				}
				
				if (map[i][j] == 'D') {
					end_x = i;
					end_y = j;
				}
			}
		}
				
		bfs();
		
		if (visited[end_x][end_y] == 0) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(visited[end_x][end_y]);
		}
	}
	
	public static void bfs() {	
		Location loc;
		while (!queue.isEmpty()) {
			int size = water_queue.size();
			while (size-- > 0) {
				loc = water_queue.poll();
				int water_x = loc.x;
				int water_y = loc.y;
				
				if (water_x >= n  && water_y >= m) {
					break;
				}

				for(int i = 0; i < 4; i++){
					int nx = water_x + dx[i];
					int ny = water_y + dy[i];

					if(nx >= 0 && ny >= 0 && nx < n && ny < m){
						if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							water_queue.add(new Location(nx, ny));
						}
					}
				}
			}
			size = queue.size();
			while (size-- > 0) {
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
						if(visited[nx][ny] == 0){
							if (map[nx][ny] != 'X' && map[nx][ny] != '*') {
								queue.add(new Location(nx, ny));
								visited[nx][ny] = visited[x][y] + 1;
							}
						}
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