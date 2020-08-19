import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Solution_11403 {
	static int[][] map;
	static int[][] answer;
	static int[] visited;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		answer = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			visited = new int[n];
			bfs(i);
			
			for (int j = 0; j < n; j++) {
				System.out.print(visited[j] + " ");
			}
			System.out.println("");
		}
		
	}

	public static void bfs(int bfs_x) {
		Queue<Integer> queue = new LinkedList<Integer>();		
		queue.add(bfs_x);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			if (x >= n) {
				break;
			}
			
			for(int i = 0; i < n; i++){
				int nx = i;
				if(nx >= 0 && nx < n){
					if(visited[nx] == 0 && map[x][i] == 1){
						queue.add(nx);
						visited[nx] = 1;
					}
				}
			}
		}
	}
}