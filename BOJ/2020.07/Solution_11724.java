import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution_11724 {
	static int[][] map;
	static boolean[] visited; 
	static int n;
	static int m;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(str.nextToken());
			int y = Integer.parseInt(str.nextToken());

			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		for (int i = 1; i <= n ; i++) { 
			if(!visited[i]){
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}		

	private static int dfs(int x) {
		visited[x] = true;
		for(int i = 1; i <= n; i++){
			if(map[x][i] == 1 && !visited[i]){
				dfs(i);
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