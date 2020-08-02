import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_7569 {
	static int[][][] map;
	static int[][][] visited; 
	static int n;
	static int m;
	static int h;
	private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    static Queue<Location> queue;
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[n][m][h];
		visited = new int[n][m][h];
		
		int flag = 1;
		
		for (int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					map[i][j][k] = Integer.parseInt(str.nextToken());
					if (map[i][j][k] == 0) {
						flag = 0;
					}
				}
			}
		}
		
		if (flag == 1) {
			System.out.println("0");
			return;
		}

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visited[i][j][k] = 0;
				}
			}
		}

		queue = new LinkedList<Location>();	
		for (int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j][k] == 1 && visited[i][j][k] == 0) {
						queue.add(new Location(i, j, k));
						visited[i][j][k] = 1;
					}
				}
			}
		}
		
		bfs();
				
		int max = -1;
		for (int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j][k] == 0) {
						if (map[i][j][k] == 0) {
							System.out.println("-1");
							return;
						}
					}
					max = Math.max(max, visited[i][j][k]);
				}
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
			int z = loc.h;

			if (x >= n  && y >= m && z >= h) {
				break;
			}

			for(int i = 0; i < 6; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nh = z + dh[i];
				
				if(nx >= 0 && ny >= 0 && nh >= 0 && nx < n && ny < m && nh < h){					
					if(map[nx][ny][nh] == 0 && visited[nx][ny][nh] == 0){
						queue.add(new Location(nx, ny, nh));
						visited[nx][ny][nh] = visited[x][y][z] + 1;
						map[nx][ny][nh] = 1;
					}
					
					if(map[nx][ny][nh] == -1 && visited[nx][ny][nh] == 0){
						visited[nx][ny][nh] = -1;
					}
				}
			}			
		}	
	}
}
class Location {
	int x, y, h;
	public Location(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
}