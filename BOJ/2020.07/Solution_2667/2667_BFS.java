import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 2667_BFS {
	static int[][] map;
	static boolean[][] visited; 
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visited = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && visited[i][j] == false) {
					int cnt = bfs(i, j);
					if (cnt != 0) {
						list.add(cnt);
					}
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) { 
			System.out.println(list.get(i)); 
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

			if (x >= n  && y >= n) {
				break;
			}

			//위로 올라가는 경우
			if (x - 1 >= 0 && map[x - 1][y] == 1 && visited[x - 1][y] == false) {
				queue.add(new Location(x - 1, y));
				visited[x - 1][y] = true;
				cnt++;
			}

			//아래로 내려가는 경우
			if (x + 1 < n && map[x + 1][y] == 1 && visited[x + 1][y] == false) {
				queue.add(new Location(x + 1, y));
				visited[x + 1][y] = true;
				cnt++;
			}

			//왼쪽으로 가는 경우
			if (y - 1 >= 0 && map[x][y - 1] == 1 && visited[x][y - 1] == false) {
				queue.add(new Location(x, y - 1));
				visited[x][y - 1] = true;
				cnt++;
			}

			//오른쪽으로 가는 경우
			if (y + 1 < n && map[x][y + 1] == 1 && visited[x][y + 1] == false) {
				queue.add(new Location(x, y + 1));
				visited[x][y + 1] = true;
				cnt++;
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