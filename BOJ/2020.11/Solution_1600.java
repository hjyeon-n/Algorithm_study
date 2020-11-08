import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1600 {
	static int[][] map;
	static boolean[][][] visited;
	static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int knightX[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int knightY[] = {-1, 1, -2, 2, -2, 2, -1, 1};
	static int W, H, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
	}
	
	public static void bfs() {
		Queue<Location> queue = new LinkedList<Location>();
		visited[0][0][0] = true;
		queue.add(new Location(0, 0, 0, 0));
		
		while(!queue.isEmpty()) {
			Location loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			int jump = loc.jump;
			int depth = loc.depth;
			
			if (x == H - 1  && y == W - 1) {
				System.out.println(depth);
				return;
			}
			
			if (K > jump) {
				for (int i = 0; i < 8; i++) {
					int nx = x + knightX[i];
					int ny = y + knightY[i];
					
	//				나이트 이동
					if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
						if (map[nx][ny] == 0 && !visited[nx][ny][jump + 1]){
							queue.add(new Location(nx, ny, jump + 1, depth + 1));
							visited[nx][ny][jump + 1] = true;
						}
					}
				}
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
//				일반 이동
				if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
					if (map[nx][ny] == 0 && !visited[nx][ny][jump]){
						queue.add(new Location(nx, ny, jump, depth + 1));
						visited[nx][ny][jump] = true;
					}
				}
			}
		}
		System.out.println("-1");
	}
}

class Location {
	int x;
	int y;
	int jump;
	int depth;
	
	public Location(int x, int y, int jump, int depth) {
		this.x = x;
		this.y = y;
		this.jump = jump;
		this.depth = depth;
	}
}