import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 2573_BFS_ver1 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited; 
	static int[][] iceberg;
	static ArrayList<Location> list;
	static ArrayList<Location> zero;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		iceberg = new int[N][M];
		list = new ArrayList<Location>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					list.add(new Location(i, j));
					iceberg[i][j] = 1;
				}
			}
		}
		
		if (list.size() == 0) {
			System.out.println("0");
			return;
		}
		
		int ice = 0;
		for (int i = 0; i < list.size(); i++) {
			Location list_loc = list.get(i);
			if (iceberg[list_loc.x][list_loc.y] != 2) {
				countIce(list_loc.x, list_loc.y);
				ice++;
			}
			
			if (ice >= 2) {
				System.out.println("0");
				return;
			}
		}
		
		int time = 1;
		while (true) {
//			제거한 후, 0이 아닐 때 리스트에 삽입
			list = new ArrayList<Location>();
			zero = new ArrayList<Location>();
			visited = new boolean[N][M];
			iceberg = new int[N][M];
			
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						removeIceBerg(i, j);
					}
				}
			}
			
			if (list.size() == 0) {
				System.out.println("0");
				return;
			}
			
			for (int i = 0; i < zero.size(); i++) {
				Location zero_loc = zero.get(i);
				map[zero_loc.x][zero_loc.y] = 0;
			}
			
			ice = 0;
			for (int i = 0; i < list.size(); i++) {
				Location list_loc = list.get(i);
				if (iceberg[list_loc.x][list_loc.y] != 2) {
					countIce(list_loc.x, list_loc.y);
					ice++;
				}
				
				if (ice >= 2) {
					System.out.println(time);
					return;
				}
			}
			
			time++;
		}
	}
	
	public static void removeIceBerg(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y));
		visited[bfs_x][bfs_y] = true;
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x >= N && y >= M) {
				break;
			}
			
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == 0) {
						cnt++;
					}
					
					if (map[nx][ny] != 0 && !visited[nx][ny]) {
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
			
			if (map[x][y] - cnt > 0) {
				map[x][y] = map[x][y] - cnt;
				list.add(new Location(x, y));
				iceberg[x][y] = 1;
			}
			else {
				zero.add(new Location(x, y));
			}
		}
	}
	
	public static void countIce(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y));
		
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x >= N && y >= M) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (iceberg[nx][ny] == 1) {
						queue.add(new Location(nx, ny));
						iceberg[nx][ny] = 2;
					}
				}
			}
		}
	}
}

class Location {
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}