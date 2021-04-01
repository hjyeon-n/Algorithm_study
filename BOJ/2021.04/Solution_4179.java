import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4179 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Location> fire;
	static Queue<Location> escape;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited =new boolean[R][C];
		
		fire = new LinkedList<Location>();
		escape = new LinkedList<Location>();
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'J') {
					if (i == 0 || j == 0 || i == R - 1 || j == C - 1) {
						System.out.println("1");
						return;
					}
					map[i][j] = '.';
					escape.add(new Location(i, j));
				}
				
				if (map[i][j] == 'F') {
					fire.add(new Location(i, j));
				}
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		int t = 0;
		while (true) {
			t++;
			int size = fire.size();
			
			while (size-- > 0) {
				Location loc = fire.poll();
				int x = loc.x;
				int y = loc.y;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (map[nx][ny] == '.') {
							map[nx][ny] = 'F';
							fire.add(new Location(nx, ny));
						}
					}
				}
			}
			
			size = escape.size();
			
			while (size-- > 0) {
				Location loc = escape.poll();
				int x = loc.x;
				int y = loc.y;
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (!visited[nx][ny] && map[nx][ny] == '.') {
							if (nx == 0 || ny == 0 || nx == R - 1 || ny == C - 1) {
								System.out.println(t + 1);
								return;
							}
							visited[nx][ny] = true;
							escape.add(new Location(nx, ny));
						}
					}
				}
			}
			
			if (escape.size() == 0) {
				System.out.println("IMPOSSIBLE");
				break;
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