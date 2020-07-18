import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_2178 {
	static int[][] map;
	static boolean[][] visited; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		System.out.println(bfs(n, m));
	}
	
	public static int bfs(int N, int M) {
		Queue<Location> queue = new LinkedList<Location>();		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = false;
			}
		}
		
		visited[0][0] = true;
		queue.add(new Location(0, 0));
		Location loc;
		
		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x == N -1  && y == M - 1) {
				break;
			}
			
			//위로 올라가는 경우
			if (x - 1 >= 0 && map[x - 1][y] == 1 && visited[x - 1][y] == false) {
				queue.add(new Location(x - 1, y));
				visited[x - 1][y] = true;
				map[x - 1][y] = map[x][y] + 1;
			}
			
			//아래로 올라가는 경우
			if (x + 1 < N && map[x + 1][y] == 1 && visited[x + 1][y] == false) {
				queue.add(new Location(x + 1, y));
				visited[x + 1][y] = true;
				map[x + 1][y] = map[x][y] + 1;
			}
			
			//왼쪽으로 가는 경우
			if (y-1 >= 0 && map[x][y - 1] == 1 && visited[x][y - 1] == false) {
				queue.add(new Location(x, y - 1));
				visited[x][y - 1] = true;
				map[x][y - 1] = map[x][y] + 1;
			}
			
			//오른쪽으로 가는 경우
			if (y + 1 < M && map[x][y + 1] == 1 && visited[x][y + 1] == false) {
				queue.add(new Location(x, y + 1));
				visited[x][y + 1] = true;
				map[x][y + 1] = map[x][y] + 1;
			}
		}
		return map[N - 1][M - 1];
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}