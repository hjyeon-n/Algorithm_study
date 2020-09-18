import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class 16234_DFS {
	static int[][] map;
	static int[][] visited; 
	static int N, L, R;
	static int cnt, sum;
	static ArrayList<Location> list;
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
						list = new ArrayList<Location>();
						sum = map[i][j];
						cnt = 1;
						dfs(i, j);
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

	public static void dfs(int x, int y) {
		visited[x][y] = 1;
		list.add(new Location(x, y));
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < N && ny < N){
				int val = Math.abs(map[nx][ny] - map[x][y]);
				if (val >= L && val <= R && visited[nx][ny] == 0) {
					sum += map[nx][ny];
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static void fillVisited() {
		for (int i = 0; i < list.size(); i++) {
			Location loc = list.get(i);
			map[loc.x][loc.y] = sum / cnt;
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