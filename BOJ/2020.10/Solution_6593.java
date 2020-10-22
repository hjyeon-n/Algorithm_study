import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_6593 {
	static int L, R, C;
	static Location end;
	static char[][][] map;
	static int[][][] visited;
	static Queue<Location> queue;
	private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			map = new char[L][R][C];
			visited = new int[L][R][C];
			queue = new LinkedList<Location>();
			for (int caseNum = 0; caseNum < L; caseNum++) {
				for (int i = 0; i < R; i++) {
					String str = br.readLine();
					for (int j = 0; j < C; j++) {
						map[caseNum][i][j] = str.charAt(j);
						
						if (map[caseNum][i][j] == 'S') {
							queue.add(new Location(caseNum, i, j));
						}
						
						if (map[caseNum][i][j] == 'E') {
							end = new Location(caseNum, i, j);
						}
					}
				}
				br.readLine();
			}
			
			if (!BFS()) {
				System.out.println("Trapped!");
			}
		}
	}
	
	public static boolean BFS() {
		while (!queue.isEmpty()) {
			Location loc = queue.poll();
			int h = loc.h;
			int x = loc.x;
			int y = loc.y;
			
			if (h == end.h && x == end.x && y == end.y) {
				System.out.println("Escaped in " + visited[h][x][y] + " minute(s).");
				return true;
			}
			
			for (int i = 0; i < 6; i++) {
				int nh = h + dh[i];
				int nx = x + dx[i];
				int ny = y + dy[i];
			
			
				if(nx >= 0 && ny >= 0 && nh >= 0 && nx < R && ny < C && nh < L){
					if(map[nh][nx][ny] == '.' || map[nh][nx][ny] == 'E'){
						if (visited[nh][nx][ny] == 0) {
							queue.add(new Location(nh, nx, ny));
							visited[nh][nx][ny] = visited[h][x][y] + 1;
						}
					}
				}
			}
		}
		return false;
	}
}

class Location {
	int h;
	int x;
	int y;
	
	public Location(int h, int x, int y) {
		this.h = h;
		this.x = x;
		this.y = y;
	}
}