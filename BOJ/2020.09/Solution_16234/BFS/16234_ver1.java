import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 16234_ver1 {
	static int[][] map;
	static int[][] visited; 
	static int N, L, R;
	static int cnt, sum;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;

		while (true) {
			visited = new int[N][N];
			
			int stop = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						bfs(i, j);
						fillVisited();
						stop++;
					}
				}
			}
			if (stop == N * N) {
				System.out.println(answer);
				return;
			}
			answer++;
		}
	}

	public static void bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(x, y));
		visited[x][y] = 1;
		sum = map[x][y];
		cnt = 1;
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int loc_x = loc.x;
			int loc_y = loc.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = loc_x + dx[i];
				int ny = loc_y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < N && ny < N){
					int val = Math.abs(map[nx][ny] - map[loc_x][loc_y]);
					if (val >= L && val <= R && visited[nx][ny] == 0) {
						sum += map[nx][ny];
						cnt++;
						visited[nx][ny] = 1;
						queue.add(new Location(nx, ny));
					}
				}
			}			
		}
	}
	
	public static void fillVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 1) {
					map[i][j] = sum / cnt;
					visited[i][j] = -1;
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