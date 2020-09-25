import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Solution_11559 {
	static ArrayList<Location> list;
	static char[][] map;
	static int[][] block;
	static boolean[][] visited;
	private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int cnt = 0;
		while (true) {
			list = new ArrayList<Location>();
			visited = new boolean[12][6];
			block = new int[12][6];
			flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !visited[i][j]) {
						bombBlock(i, j);
					}
				}
			}
			
			if (!flag) {
				break;
			}
			else {
				moveBlock();
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void bombBlock(int bfs_x, int bfs_y) {
		Queue<Location> queue = new LinkedList<Location>();		
		visited[bfs_x][bfs_y] = true;
		queue.add(new Location(bfs_x, bfs_y));
		Location loc;
		list = new ArrayList<Location>();
		list.add(new Location(bfs_x, bfs_y));
		
		int cnt = 1;
		char alpha = map[bfs_x][bfs_y];
		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			for(int i = 0; i < 4; i++){
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx >= 0 && ny >= 0 && nx < 12 && ny < 6){
					if(map[nx][ny] == alpha && !visited[nx][ny]){
						queue.add(new Location(nx, ny));
						list.add(new Location(nx, ny));
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}
		
		if (cnt >= 4) {
			while(!list.isEmpty()) {
				Location bomb = list.get(0); 
				block[bomb.x][bomb.y] = 1;
				list.remove(0);
			}
			flag = true;
		}
	}
	
	public static void moveBlock() {
		for (int i = 0; i < 6; i++) {
			Queue<Integer> zero = new LinkedList<Integer>();
			for (int j = 11; j >= 0; j--) {
				if (block[j][i] == 0) {
					zero.add(j);
				}
			}
			
			int j = 11;
			while(!zero.isEmpty()) {
				int x = zero.poll();
				map[j--][i] = map[x][i];
			}
			
			while (j >= 0) {
				map[j--][i] = '.';
			}
		}
	}
}
class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}