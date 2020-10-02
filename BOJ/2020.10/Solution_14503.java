import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, answer;
	static boolean[][] visited;
	static int[][] map;
	static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 1;
		Location loc = new Location(r, c, d);
		BFS(loc);
		System.out.println(answer);
	}
	
	public static void BFS(Location loc) {
		Queue<Location> queue = new LinkedList<Location>();
		visited[loc.x][loc.y] = true;
		queue.offer(loc);
		
		while (!queue.isEmpty()) {
			Location queue_loc = queue.poll();
			int x = queue_loc.x;
			int y = queue_loc.y;
			int d = queue_loc.d;
			
			if (x >= N && y >= M) {
				break;
			}
			
			int next = d;
			int nx, ny;
			boolean flag = false;
			for (int i = 0; i < 4; i++) {
				next = turnDirection(next);
				nx = x + dx[next];
				ny = y + dy[next];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0 && !visited[nx][ny]) {
						queue.offer(new Location(nx, ny, next));
						visited[nx][ny] = true;
						answer++;
						flag = true;
						break;
					}
				}
			}
			
			if (!flag) {
				next = goBack(d);
				nx = x + dx[next];
				ny = y + dy[next];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0) {
						queue.offer(new Location(nx, ny, d));
					}
				}
			}
		}
	}
	
	public static int turnDirection(int d) {
		if (d == 0) { // ºÏ
			return 3;
		}
		else if (d == 1) { // µ¿
			return 0;
		}
		else if (d == 2) { // ³²
			return 1;
		}
		else { // ¼­
			return 2;
		}
	}
	
	public static int goBack(int d) {
		if (d == 0) { // ºÏ
			return 2;
		}
		else if (d == 1) { // µ¿
			return 3;
		}
		else if (d == 2) { // ³²
			return 0;
		}
		else { // ¼­
			return 1;
		}
	}
} 

class Location {
	int x;
	int y;
	int d;
	
	public Location(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}