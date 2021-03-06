import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int[][] map;
	static boolean[][] visited; 
	static int m;
	static int n;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];

		for (int loop = 0; loop < k; loop++) {
			st = new StringTokenizer(br.readLine());
			int Ay = Integer.parseInt(st.nextToken());
			int Ax = Integer.parseInt(st.nextToken());
			int By = Integer.parseInt(st.nextToken());
			int Bx = Integer.parseInt(st.nextToken());
			
			for (int x = Ax; x < Bx; x++) {
				for (int y = Ay; y < By; y++) {
					map[x][y] = 1;
				}
			}			
		}
						
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 0 && visited[i][j] == false) {
					list.add(bfs(i, j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) { 
			System.out.print(list.get(i) + " "); 
		}
	}

	public static int bfs(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = true;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;

		int cnt = 1;

		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;

			if (x >= m  && y >= n) {
				break;
			}

			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < m && ny < n){
					if(map[nx][ny] == 0 && !visited[nx][ny]){
						queue.add(new Location(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}	
		return cnt;
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}