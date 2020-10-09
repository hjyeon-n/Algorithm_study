import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16236 {
	static int N;
	static int cnt;
	static ArrayList<Location> fish;
	static int shark;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		Location sharkLoc = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 9) {
					sharkLoc = new Location(i, j, 0);
				}
			}
		}
		
		shark = 2;
		cnt = 0;
		fish = new ArrayList<Location>();
		visited= new boolean[N][N];
		bfs(sharkLoc.x, sharkLoc.y);
		
		if (fish.size() == 0) {
			System.out.println("0");
			return;
		}
		
		int time = 0;
		while (!fish.isEmpty()) {
			ArraySort();
			Location fishLoc = fish.get(0);
			fish = new ArrayList<Location>();
			map[sharkLoc.x][sharkLoc.y] = 0;
			map[fishLoc.x][fishLoc.y] = 9;
			sharkLoc = fishLoc;
			time += fishLoc.time;
			cnt++;
			
			if (cnt == shark) {
				shark += 1;
				cnt = 0;
			}
			visited= new boolean[N][N];
			bfs(sharkLoc.x, sharkLoc.y);
		}
		
		System.out.println(time);
	}
	
	public static void bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(new Location(bfs_x, bfs_y, 0));
		visited[bfs_x][bfs_y] = true;
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int time = loc.time + 1;
			int x = loc.x;
			int y = loc.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (shark > map[nx][ny] && map[nx][ny] != 0 && !visited[nx][ny]) {
						fish.add(new Location(nx, ny, time));
						visited[nx][ny] = true;
					}
					if (shark >= map[nx][ny] && !visited[nx][ny]) {
						queue.add(new Location(nx, ny, time));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static void ArraySort() {
		Collections.sort(fish, new Comparator<Location>() {
			@Override
			public int compare(Location o1, Location o2) {
				int a = o1.time;
				int b = o2.time;
				if (a > b) {
					return 1;
				}
				if (a < b) {
					return -1;
				}
				else {
					if (o1.x < o2.x) { 
						return -1; 
					} 
					else if (o1.x > o2.x) { 
						return 1; 
					} 
					else {
						if (o1.y < o2.y) { 
							return -1; 
						} 
						else if (o1.y > o2.y) { 
							return 1; 
						} 
						return 0;
					}
				}
			}
		});
	}
}

class Location {
	int x;
	int y;
	int time;
	
	public Location(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}