import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5427 {
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int w, h, min;
	static Queue<Location> queue, fire_queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new int[h][w];
			int[][] copy = new int[h][w];
			
			fire_queue = new LinkedList<Location>();
			queue = new LinkedList<Location>();
			
			for (int j = 0; j < h; j++) {
				String str = br.readLine();
				
				for (int k = 0; k < w; k++) {
					map[j][k] = str.charAt(k);
					copy[j][k] = map[j][k];
					
//					시작점일 때
					if (map[j][k] == '@') {
						visited[j][k] = 1;
						queue.add(new Location(j, k));
					}
					
//					불일 때
					if (map[j][k] == '*') {
						fire_queue.add(new Location(j, k));
					}
				}
			}
//			끝점에 도달했는지 확인
			min = Integer.MAX_VALUE;
			
			bfs();
			
			if (min == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(min);
			}
		}
	}
	
	public static void bfs() {
		Location loc;
		
		while(!queue.isEmpty()) {
			int size = fire_queue.size();
			while (size-- > 0) {
				loc = fire_queue.poll();
				int fire_x = loc.x;
				int fire_y = loc.y;
				
				if (fire_x >= h  && fire_y >= w) {
					break;
				}

				for(int i = 0; i < 4; i++){
					int nx = fire_x + dx[i];
					int ny = fire_y + dy[i];

					if(nx >= 0 && ny >= 0 && nx < h && ny < w){
						if (map[nx][ny] == '.' || map[nx][ny] == '@') {
							map[nx][ny] = '*';
							fire_queue.add(new Location(nx, ny));
						}
					}
				}
			}
			
			size = queue.size();
			while (size-- > 0) {
				loc = queue.poll();
				int x = loc.x;
				int y = loc.y;

				if(x == 0 || y == 0 || x == h - 1 || y == w - 1){
					min = Math.min(min, visited[x][y]);
				}
				
				if (x >= h  && y >= w) {
					break;
				}

				for(int i = 0; i < 4; i++){
					int nx = x + dx[i];
					int ny = y + dy[i];

					if(nx >= 0 && ny >= 0 && nx < h && ny < w){
						if(visited[nx][ny] == 0){
							if (map[nx][ny] != '#' && map[nx][ny] != '*') {
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
	int x;
	int y;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}